package dataAccess.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	User getById(int id);
	List<User> getAll();
	List<String> getEmails();
	User getByEmail(String email);
	boolean ifMailExists(User user);
	boolean ifPasswordExists(User user);
	
}
