package Kamp5GunOdev.business.abstracts;

import java.util.ArrayList;
import java.util.List;

import Kamp5GunOdev.entities.concretes.User;

public interface AuthService {
	void signIn(User user);
	Boolean signUp(User user,ArrayList<User> array);
	
}
