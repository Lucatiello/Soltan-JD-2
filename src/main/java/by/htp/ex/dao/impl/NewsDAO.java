package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.INewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.dao.conPool.ConnectionPool;
import by.htp.ex.dao.conPool.ConnectionPoolException;

public class NewsDAO implements INewsDAO {
	
	private static final ConnectionPool poolNews = ConnectionPool.getInstance();

	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException {
		List<News> result = new ArrayList<News>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int i = 0;

		try {
//			con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/db_trainingm?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false",
//					"root", "Artyom");
			con = poolNews.takeConnection();
			st = con.createStatement();
         	rs = st.executeQuery("SELECT * FROM news ORDER BY news_date DESC");

			while (rs.next() && i < count) {

				i++;
//			System.out.println(rs.getInt("id")+"  "+rs.getString("title") + " "+ rs.getString("brief_news") +
//					rs.getString("content") + rs.getString("news_date")+  rs.getString("newscol"));

				result.add(new News(rs.getInt("id"), rs.getString("title"), rs.getString("brief_news"),
						rs.getString("content"), rs.getString("news_date"), rs.getString("newscol")));

			}
		} catch (SQLException e) {

			throw new NewsDAOException("Bad connection with DB!");
		} catch (ConnectionPoolException e) {
			throw new NewsDAOException("Connection pool problem");
		}

		finally {
			
			poolNews.closeConnection(con, st, rs);

//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//				
//			}
//			
//			try {
//				if (st != null) {
//					st.close();
//				}
//				
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//			
//			
//			try {
//				if (con != null) {
//					con.close();
//				}
//
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
		}


		return result;
	}

	@Override
	public List<News> getList() throws NewsDAOException {
		List<News> result = new ArrayList<News>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			
			con = poolNews.takeConnection();
//			con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/db_trainingm?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false",
//					"root", "Irina1983");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM news ORDER BY news_date DESC");

			while (rs.next()) {

				result.add(new News(rs.getInt("id"), rs.getString("title"), rs.getString("brief_news"),
						rs.getString("content"), rs.getString("news_date"), rs.getString("newscol")));

			}
		} catch (SQLException e) {

			throw new NewsDAOException("Problem with DB");
		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			throw new NewsDAOException("Problem with connection pool");
		}

		finally {

			poolNews.closeConnection(con, st, rs);
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//				
//			}
//			
//			try {
//				if (st != null) {
//					st.close();
//				}
//				
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//			
//			
//			try {
//				if (con != null) {
//					con.close();
//				}
//
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
		}



		return result;
	}

	@Override
	public News fetchById(int idNews) throws NewsDAOException {

		News news = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {

//			con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/db_trainingm?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false",
//					"root", "Irina1983");
			con = poolNews.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM news");
			while (rs.next()) {
				if (rs.getInt("id") == idNews) {
					news = new News(rs.getInt("id"), rs.getString("title"), rs.getString("brief_news"),
							rs.getString("content"), rs.getString("news_date"), rs.getString("newscol"));
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {

			poolNews.closeConnection(con, st, rs);
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//				
//			}
//			
//			try {
//				if (st != null) {
//					st.close();
//				}
//				
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//			
//			
//			try {
//				if (con != null) {
//					con.close();
//				}
//
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
		}
		


		return news;

	}

	@Override
	public int addNews(News news) throws NewsDAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateNews(News news) throws NewsDAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteNewses(String[] idNewses) throws NewsDAOException {
		// TODO Auto-generated method stub

	}

}