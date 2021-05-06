package Kamp5GunOdev.dataAccess.abstracts;

import Kamp5GunOdev.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	boolean isValid(String valid,User user) ;
}
