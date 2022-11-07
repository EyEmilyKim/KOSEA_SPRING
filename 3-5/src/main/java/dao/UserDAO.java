package dao;

import model.User;

public interface UserDAO {
	void create(User user);
	User getUser(User user);
}