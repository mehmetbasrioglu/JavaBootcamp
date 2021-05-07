package business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.AuthenticationService;
import business.abstracts.UserService;
import entities.concretes.User;

public class AuthenticationManager implements AuthenticationService{
	
	private UserService userService;

	public AuthenticationManager(UserService userService) {
		super();
		this.userService = userService;
	}
	@Override
	public void signIn(User user) {
		// TODO Auto-generated method stub
	   
		if(userService.ifMailExists(user) && userService.ifPasswordExists(user)) {
			if(user.isValid()) {
				System.out.println("Ho�geldin:"+user.getFirstName());
			}
			else {
				System.out.println("Do�rulanmam�� hesap");
			}
		}
		else {
			System.out.println("Email bulunamad�");
		}
		
		
	}

	@Override
	public void signUp(User user) {
		// TODO Auto-generated method stub
		if(isFirstNameNull(user.getFirstName()) && isLastNameNull(user.getLastName())
				&& isEmailNull(user.getEmail()) && isEmailTypeTrue(user.getEmail()) 
				&& isPasswordNull(user.getPassword()) && checkPasswordLength(user.getPassword())
				&& checkFirstNameLength(user.getFirstName()) && checkLastNameLength(user.getLastName()) )
			{
			 
			   userService.add(user);
			   user.setValidCode(generateRandomValidCode(user));
			   
			   
				return;
			}
	}
	
	private String generateRandomValidCode(User user) {
		int rand = (int) Math.floor(Math.random() * 9999);
		return rand + "" + user.getFirstName().substring(0, 1) + ""+user.getId()+ "" + user.getLastName().substring(0, 1);
	}

	@Override
	public void verify(User user, String code) {
		// TODO Auto-generated method stub
		if(user.getValidCode() == code) {
			user.setValid(true);
			System.out.println("Do�ruland�");
		}
		
	}
	
	private boolean isFirstNameNull(String firstname) {
		if(firstname == null || firstname == "") {
			return false;
		}
		return true;
	}
	private boolean isLastNameNull(String lastname) {
		if(lastname == null || lastname == "") {
			return false;
		}
		return true;
	}
	private boolean isEmailNull(String mail) {
		if(mail == null || mail == "") {
			System.out.println("Email Adresi Bo� B�rak�lamaz");
			return false;
		}
		return true;
	}
	
	private boolean isEmailTypeTrue(String mail) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		
		if(!matcher.matches()) {
			System.out.println("Email Adresi Do�ru De�il");
			return false;
		}
		return true;
	}
	
	private boolean isPasswordNull(String pass) {
		if(pass == null || pass == "") {
			System.out.println("�ifre Bo� B�rak�lamaz");
			return false;
		}
		return true;
	}
	private boolean checkFirstNameLength(String firstname) {
		if(firstname.length() < 2) {
			System.out.println("Ad�n�z en az 2 haneli olmal�d�r");
			return false;
		}
		return true;
	}
	
	private boolean checkLastNameLength(String lastname) {
		if(lastname.length() < 2) {
			System.out.println("SoyAd�n�z en az 2 haneli olmal�d�r");
			return false;
		}
		return true;
	}
	
	private boolean checkPasswordLength(String pass) {
		if(pass.length() < 6) {
			System.out.println("�ifre en az 6 haneli olmal�d�r");
			return false;
		}
		return true;
	}

	

}
