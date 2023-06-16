package by.htp.ex.dao.impl;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.Role;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.DaoException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class UserDAO implements IUserDAO {
	private final List<NewUserInfo> users;

	{
		users = new ArrayList<>();
		NewUserInfo userOne = new NewUserInfo("Admin", "a@mail.com", "a");
		NewUserInfo userTwo = new NewUserInfo("User", "u@mail.com", "u");
		userOne.setRole(Role.ADMIN);
		userTwo.setRole(Role.USER);
		users.add(userOne);
		users.add(userTwo);
	}

	@Override
	public boolean isExistUser(NewUserInfo user) {
		Optional<NewUserInfo> userInfo = users.stream().filter(u -> u.getEmail().equals(user.getEmail())).findAny();
		return userInfo.isPresent();
	}

	@Override
	public NewUserInfo authorization(String login) {
		return users.stream().filter(u -> u.getLogin().equals(login)).findAny().orElse(null);
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException {
		return users.add(user);
	}
}