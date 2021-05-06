package Kamp5GunOdev.business.abstracts;

import java.util.ArrayList;

import Kamp5GunOdev.entities.concretes.User;

public interface UserService {
	void addUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
	
}
