package by.htp.library.dao;


import by.htp.library.domain.User;

public interface UserDAO {
User authorization (String login, String password);
User registration (String name,String surname,String login,String password);
}
