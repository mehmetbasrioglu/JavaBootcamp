package console;

import business.concretes.AuthenticationManager;
import business.concretes.UserManager;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Katmanl� Mimari �rnek al��t�rma tekrar�

		User kullanici1 = new User(1,"Mehmet","Basrio�lu ","mehmet@gmail.com","123456");
		User kullanici2 = new User(2,"Mehmet","Basrio�lu","mehmet2@gmail.com","123456");
		
		InMemoryUserDao dao = new InMemoryUserDao();
		UserManager manager = new UserManager(dao);
		
		AuthenticationManager auth = new AuthenticationManager(manager);
		auth.signUp(kullanici1);
		auth.verify(kullanici1, kullanici1.getValidCode());
		auth.signUp(kullanici2);
		auth.verify(kullanici2, kullanici2.getValidCode());
		auth.signIn(kullanici2);
		
		
	
		
		
		
		
		
	}

}
