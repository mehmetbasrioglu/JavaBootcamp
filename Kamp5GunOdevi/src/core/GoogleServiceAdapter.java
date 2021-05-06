package core;

import googleServices.GoogleAuthManager;

public class GoogleServiceAdapter{
	
	public void signIn(String email, String password) {
		// TODO Auto-generated method stub
		GoogleAuthManager googleAuth = new GoogleAuthManager();
		googleAuth.sign(email, password);
		
	}
	
}
