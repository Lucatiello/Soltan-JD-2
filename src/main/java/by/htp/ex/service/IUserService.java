package by.htp.ex.service;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.service.ServiceException;

public interface IUserService {
	
	String signIn(String login, String password) throws ServiceException;
	boolean registration(NewUserInfo user) throws ServiceException;

}
