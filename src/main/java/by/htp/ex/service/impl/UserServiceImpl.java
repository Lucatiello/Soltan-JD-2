package by.htp.ex.service.impl;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.Role;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.DaoException;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;

public final class UserServiceImpl implements IUserService {
	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();

	@Override
	public String signIn(String login, String password) throws ServiceException {

		try {
			NewUserInfo userDao = userDAO.authorization(login);
			if (userDao != null && userDao.getPassword().equals(password))
				return userDao.getRole().toString().toLowerCase();
			return Role.GUEST.toString().toLowerCase();
		}

		catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean registration(NewUserInfo user) throws ServiceException {

		try {
			if (userDAO.isExistUser(user)) {
				throw new DaoException("User with this email exists");
			}
			return (userDAO.registration(user));
		}

		catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}