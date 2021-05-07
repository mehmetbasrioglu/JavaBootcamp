package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager  implements UserService{
	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		if(!ifMailExists(user)) {
			userDao.add(user);
			
		}
		else {
			System.out.println("E mail zaten kayýtlý");
			return;
		}
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
		
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public boolean ifMailExists(User user) {
		// TODO Auto-generated method stub
		return userDao.ifMailExists(user);
	}

	
	@Override
	public boolean ifPasswordExists(User user) {
		// TODO Auto-generated method stub
		return userDao.ifPasswordExists(user);
	}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.getByEmail(email);
	}
	


}
