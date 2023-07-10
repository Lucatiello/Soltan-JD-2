package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.UserDaoException;
import by.htp.ex.dao.conPool.ConnectionPool;
import by.htp.ex.dao.conPool.ConnectionPoolException;
import jakarta.faces.view.ActionSource2AttachedObjectTarget;
import by.htp.ex.dao.IUserDAO;

public class UserDAO implements IUserDAO {
	
		
		private static final ConnectionPool pool = ConnectionPool.getInstance();
	    private static final String CHECK_LOGIN = "SELECT * FROM users WHERE login = ?";
		private static final String GET_ROLE_ID = "SELECT * FROM users_has_role WHERE 	users_id = ?";
	

	@Override
	public boolean logination(String loginFromWeb, String passwordFromWeb) throws UserDaoException {

		/*
		 * Random rand = new Random(); int value = rand.nextInt(1000);
		 * 
		 * if(value % 3 == 0) { try { throw new SQLException("stub exception");
		 * }catch(SQLException e) { throw new DaoException(e); } }else if (value % 2 ==
		 * 0) { return true; }else { return false; }
		 */
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ResultSet rsRole = null;
		
			
		NewUserInfo user = null;

		try {

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_trainingm?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false",
					"root", "Irina1983");
			
			//con = pool.takeConnection();
			PreparedStatement ps = con.prepareStatement(CHECK_LOGIN);
			ps.setString(1, loginFromWeb);
			// ps.setString(2, passwordFromWeb);

//			st = con.createStatement();
//			rs = st.executeQuery(sqlLogin);

			rs = ps.executeQuery();

			if (rs.next() && BCrypt.checkpw(passwordFromWeb, rs.getString("password"))) {

				int idFromUsers = rs.getInt("id");
				
				
				ps = con.prepareStatement(GET_ROLE_ID);
				ps.setInt(1, idFromUsers);
				rsRole = ps.executeQuery();

				String role = "guest";
				int idRole;

				if (rsRole.next()) {
				
					idRole = rsRole.getInt("roles_id");

					if (idRole == 1) {
						role = "user";
					}
					if (idRole == 2) {

						role = "admin";
					
						}

					user = new NewUserInfo(rs.getInt("id"), rs.getString("login"), role);
					
				}
				
								
				
				
//				PreparedStatement psRoleID = con.prepareStatement(GET_ROLE_ID);
//				psRoleID.setInt(1, idFromUsers);
//				rsRole = psRoleID.executeQuery();
//
//				String role = "guest";
//				int idRole;
//
//				if (rsRole.next()) {
//				
//					idRole = rsRole.getInt("roles_id");
//
//					if (idRole == 1) {
//						role = "user";
//					}
//					if (idRole == 2) {
//
//						role = "admin";
//					
//						}
//
//					user = new NewUserInfo(rs.getInt("id"), rs.getString("login"), role);
//					System.out.println(user);
//				}

				
			} else {
				throw new UserDaoException("No such user, check the data or register");
			}

			// while (rs.next()) {

//				if (rs.getString("login").equals(login) && rs.getString("password").equals(password)) {
//
//					flag = true;
//					break;
//				} else {
//					flag = false;
//				}
//			}

		} catch (SQLException e) {
			throw new UserDaoException("No such user, check the data or register");
		} 

		finally {
			
			
			
			try {
				if (rsRole != null) {
					rsRole.close();
				}
			} catch (SQLException e) {
				throw new UserDaoException(" rsRole DB problem");

			}
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new UserDaoException(" rs DB problem");

			}
			try {
				if (st != null) {
					st.close();
				}

			} catch (SQLException e) {
				throw new UserDaoException(" st DB problem");

			}

			try {
				if (con != null) {
					con.close();
				}
			}

			catch (SQLException e) {
				throw new UserDaoException(" con DB problem");
			}
		}
			
		return user;

	}

	public String getRole(String login, String password) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		return "user";
	}

	final String ADD_USER = "INSERT INTO users(login,password) VALUES(?,?)";

	@Override
	public boolean registrationDB(NewUserInfo user) throws UserDaoException {

		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

//			con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/db_trainingm?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false",
//					"root", "Irina1983");

			con = pool.takeConnection();
			ps = con.prepareStatement(ADD_USER);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			int i = ps.executeUpdate();
			// System.out.println("i = " + i + "done ");

		} catch (SQLException e) {
			throw new UserDaoException("Data not saved in DB, check fields!");
		} catch (ConnectionPoolException e) {
			
			throw new UserDaoException("Pool doesn't work");
			
		}

		finally {
			
						
			pool.closeConnection(con, st, rs);
			
			
		//	pool.clearConnectionQueue();
			
			
			
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//			} catch (SQLException e) {
//				throw new UserDaoException("DB problem");
//
//			}
//			try {
//				if (st != null) {
//					st.close();
//				}
//
//			} catch (SQLException e) {
//				throw new UserDaoException("DB problem");
//
//			}
//
//			try {
//
//				if (ps != null) {
//					ps.close();
//				}
//			} catch (SQLException e) {
//				throw new UserDaoException("DB problem");
//			}
//
//			try {
//				if (con != null) {
//					con.close();
//				}
//			}
//
//			catch (SQLException e) {
//				throw new UserDaoException("DB problem");
//			}
		}

		return true;
	}

}