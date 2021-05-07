package business.abstracts;

import entities.concretes.User;

public interface AuthenticationService {
	void signIn(User user);
	void signUp(User user);
	void verify(User user, String code);
	
}
