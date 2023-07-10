package by.htp.ex.service.impl;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.UserDaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.IUserService;

public class UserServiceImpl implements IUserService {

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();
//	private final UserDataValidation userDataValidation = ValidationProvider.getIntsance().getUserDataVelidation();

	@Override
	public NewUserInfo signIn(String login, String password) throws ServiceException {

		/*
		 * if(!userDataValidation.checkAUthData(login, password)) { throw new
		 * ServiceException("login ...... "); }
		 */

		NewUserInfo userService = null;

		try {
			// if (userDAO.logination(login, password)) {
			
			
				//return userDAO.getRole(login, password);
//				return userService;
//
//			} else {
//				//return "guest";
//				return userService;
//			}
			
			userService = userDAO.logination(login, password);
		
			return userService;

		} catch (UserDaoException e) {
			throw new ServiceException(e);
		}

			
	}

	@Override
	public boolean registration(NewUserInfo user) throws ServiceException {

		try {
			userDAO.registrationDB(user);
		} catch (UserDaoException e) {

			throw new ServiceException(e);
		}

		return true;

	}

}