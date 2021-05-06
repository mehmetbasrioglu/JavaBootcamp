package business.concretes;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import core.GoogleServiceAdapter;
import entities.concretes.User;

public class AuthManager implements AuthService{
	private UserService userService;
	

	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}
	

	@Override
	public void signWithGoogleService(User user) {
		// TODO Auto-generated method stub
		user.setVerified(true);
		if(checkUserForLogin(user)) {
			GoogleServiceAdapter googleApi = new GoogleServiceAdapter();
			googleApi.signIn(user.getEmail(), user.getPassword());
			
			
			return;
		}
		System.out.println("Do�rulanmam�� Hesap");
		
	}
	
	@Override
	public void signIn(User user) {
		// TODO Auto-generated method stub
		if(checkUserForLogin(user)) {
			if(	userService.ifEmailExists(user) && userService.ifPasswordExists(user)) {
				System.out.println("Giri� Yap�ld�");
			}
			else {
				System.out.println("Email veya �ifre uyu�mad�");
			}

			return;
		}
		System.out.println("Do�rulanmam�� Hesap");
		
	}

	@Override
	public void signUp(User user) {
		// TODO Auto-generated method stub
		userService.add(user);
		int random = (int)Math.floor(Math.random()*9999);
		String dogrulamaKodu = user.getFirstName().substring(0, 1) + ""+user.getId()+""+user.getLastName().substring(0, 1)+""+random;
		System.out.println("Do�rulama Kodu: "+dogrulamaKodu);
		user.setVerifyCode(dogrulamaKodu);
	
		
		
		
	}

	@Override
	public void verify(User user, String code) {
		// TODO Auto-generated method stub
		User verifiedUser = userService.get(user.getId());
		if(verifiedUser.getVerifyCode() == code) {
			verifiedUser.setVerified(true);
			System.out.println("Kod Do�ruland�");
			return;
		}
		System.out.println("Do�rulama Kodu Hatal�");
	}
	
	private boolean checkUserForLogin(User user) {
		if(user.isVerified() && !(user.getEmail().isBlank() && user.getEmail() == null) && 
				!(user.getPassword().isBlank() && user.getPassword() == null) ) {
			return true;
		}
		return false;
	}



}
