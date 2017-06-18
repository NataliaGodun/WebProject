package by.htp.library.service;

import by.htp.library.domain.User;

public interface UserService {
User authorization(String login, String password);
}
