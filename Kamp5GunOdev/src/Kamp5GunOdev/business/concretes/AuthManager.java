package Kamp5GunOdev.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Kamp5GunOdev.business.abstracts.AuthService;
import Kamp5GunOdev.entities.concretes.User;

public class AuthManager implements AuthService{

	
	
	
	@Override
	public void signIn(User user) {
		// TODO Auto-generated method stub
		
		 
		
		
	}

	@Override
	public Boolean signUp(User user,ArrayList<User> array) {
		// TODO Auto-generated method stub
		String regex = "^(.+)@(.+)$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
			 
		if(user.getFirstName().length() >= 2 && user.getLastName().length() >= 2) {
			if(matcher.matches()) {
				if(user.getPassword().length() >= 6) {
					for (User user2 : array) {
						if(user2.getEmail() == user.getEmail()) {
							System.out.println("Email zaten kayýtlý");
							return false;
						}
					}
				}
				else {
					System.out.println("Hata ! : En az 6 haneden oluþmak zorundadýr");
					return false;
				}
			}
			else {
				System.out.println("Hatalý Email Girdiniz");
				return false;
			}
		}
		else {
			System.out.println("Adýnýz SoyAdýnýz 2 den büyük olmalýdýr");
			return false;
		}
		System.out.println("Baþarýlý þekilde kayýt olundu lütfen epostanýza gelen doðrulama linkine týklayýnýz");
		System.out.println("Doðrulama Kodunuz:"+user.getVerificationCode());
		return true;
		
		
		
		
	}
}
