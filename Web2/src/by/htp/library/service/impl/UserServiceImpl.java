package by.htp.library.service.impl;

import by.htp.library.domain.User;
import by.htp.library.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserServiceImpl implements UserService {

	@Override
	public User authorization(String login, String password) {
		User user = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/list", "root", "");
			st = con.createStatement();
			String sql="SELECT * FROM USERS where login=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, login);
			rs = ps.executeQuery();
			while (rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String surname=rs.getString(3);
			String loginBD=rs.getString(4);
			String passwordBD=rs.getString(5);
			user=new User(id,name,surname,loginBD,passwordBD);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

}
