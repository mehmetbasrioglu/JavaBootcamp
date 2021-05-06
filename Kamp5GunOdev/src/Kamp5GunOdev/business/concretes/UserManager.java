package Kamp5GunOdev.business.concretes;

import java.util.ArrayList;

import Kamp5GunOdev.business.abstracts.AuthService;
import Kamp5GunOdev.business.abstracts.UserService;
import Kamp5GunOdev.dataAccess.abstracts.UserDao;
import Kamp5GunOdev.entities.concretes.User;

public class UserManager implements UserService{
    private AuthService authService;
	private UserDao userdao;
	private ArrayList<User> array;
	/**
	 * @param authService
	 * @param userdao
	 */
	public UserManager(AuthService authService, UserDao userdao,ArrayList<User> array) {
		super();
		this.authService = authService;
		this.userdao = userdao;
		this.array = array;
		
		
	}
	
	
	

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		if(this.authService.signUp(user, array) == false) {

return;
		}
		else {
			this.userdao.add(user);
		}
	
		
		
	}













}
