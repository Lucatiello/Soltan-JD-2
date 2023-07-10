package by.htp.ex.dao;

import by.htp.ex.bean.NewUserInfo;

public interface IUserDAO {
	
	boolean logination(String login, String password) throws UserDaoException;
	boolean registrationDB(NewUserInfo user) throws UserDaoException;
	String getRole(String login, String password) throws UserDaoException;

}
