import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.GoogleServiceAdapter;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User kullanici1 = new User(1,"Engin","Demiroð","engindmrg@gmail.com","1234567");
		User kullanici2 = new User(2,"Engin","Demiroð 2","engindmrg2@gmail.com","1234567");
		User kullanici3 = new User(1,"Engin","Demiroð 3","engindemiroð@gmail.com","1234567");
		 
		
		
		
		
		UserManager manager = new UserManager(new InMemoryUserDao());
		
		
		
		AuthManager auth = new AuthManager(manager);
		auth.signUp(kullanici1);
//		auth.verify(kullanici1, kullanici1.getVerifyCode());
		auth.signWithGoogleService(kullanici1);
		manager.update(kullanici3);
		
		
		
		
		
		
		
		
	}

}
