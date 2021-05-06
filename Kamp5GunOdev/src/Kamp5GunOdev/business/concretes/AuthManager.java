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
							System.out.println("Email zaten kay�tl�");
							return false;
						}
					}
				}
				else {
					System.out.println("Hata ! : En az 6 haneden olu�mak zorundad�r");
					return false;
				}
			}
			else {
				System.out.println("Hatal� Email Girdiniz");
				return false;
			}
		}
		else {
			System.out.println("Ad�n�z SoyAd�n�z 2 den b�y�k olmal�d�r");
			return false;
		}
		System.out.println("Ba�ar�l� �ekilde kay�t olundu l�tfen epostan�za gelen do�rulama linkine t�klay�n�z");
		System.out.println("Do�rulama Kodunuz:"+user.getVerificationCode());
		return true;
		
		
		
		
	}
}
