import java.util.ArrayList;

import Kamp5GunOdev.business.concretes.AuthManager;
import Kamp5GunOdev.business.concretes.UserManager;
import Kamp5GunOdev.dataAccess.concretes.HibernateUserDao;
import Kamp5GunOdev.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Yeni kullan�c�
		User kullanici1 = new User(1,"Melis","Y�lmaz","abc@gmail.com","1234567");
		//Sistemde �nceden kay�tl� olanlar
		User kullanici2 = new User(2,"Mehmet","Basrio�lu","abc2@gmail.com","123456abc");
		User kullanici3 = new User(3,"A","A","dwqwq�dwq@gmail.com","123456abc");
		
		
		ArrayList<User> kullanicilar = new ArrayList<User>();
		kullanicilar.add(kullanici1);
		kullanicilar.add(kullanici3);

		
		
		
		AuthManager auth = new AuthManager();
		HibernateUserDao hb = new HibernateUserDao();

		UserManager usm = new UserManager(auth,hb,kullanicilar);
		if(kullanici2.getIsVerified() == false ) {
			usm.addUser(kullanici2);
			hb.isValid(kullanici2.getVerificationCode(), kullanici2);
		}
		

		

	}

}
