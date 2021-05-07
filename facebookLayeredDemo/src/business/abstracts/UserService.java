package business.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserService {
	void add(User user);
	void update(User user);
	void delete(User user);
	User getById(int id);
	List<User> getAll();
	User getByEmail(String email);
	boolean ifMailExists(User user);
	boolean ifPasswordExists(User user);
	
	
}
