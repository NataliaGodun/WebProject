package by.htp.library.service.impl;

import by.htp.library.domain.User;
import by.htp.library.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User authorization(String login, String password) {
		User user=new User();
		user.setName("Ivan");
		user.setSurname("Ivanov");
		return null;
	}

}
