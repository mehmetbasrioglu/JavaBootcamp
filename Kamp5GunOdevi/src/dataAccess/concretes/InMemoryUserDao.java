package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	private List<User> users;
	

	public InMemoryUserDao() {
		super();
		this.users = new ArrayList<User>();
	}
	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		users.add(user);
		System.out.println(user.getEmail() + " Kayýt Oldu");
		
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		User updatedUser = users.stream().filter(u -> u.getId() == user.getId()).findFirst().get();
		System.out.println(updatedUser.toString());
		
		updatedUser.setId(user.getId());
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setPassword(user.getPassword());
		
		
		

		System.out.println( updatedUser.toString()+ " Güncellendi");
		

		
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		User upadetedUser = users.stream().filter(u -> u.getId() == user.getId()).findFirst().get();
		users.remove(upadetedUser);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return users.stream().filter(u -> u.getId() == id).findFirst().get();
	}

	@Override
	public List<String> getEmails() {
		// TODO Auto-generated method stub
		List<String>  emails = new ArrayList<String>();
		for (User user : users) {
			emails.add(user.getEmail());
		}
		return emails;
	}

	@Override
	public boolean isMailMatch(User  user) {
		// TODO Auto-generated method stub
		
		return getEmails().stream().anyMatch(x -> x == user.getEmail());
	}

	@Override
	public boolean isPasswordMatch(User user) {
		// TODO Auto-generated method stub
		return users.stream().anyMatch(user_ -> user_.getPassword() == user.getPassword());
	}



}
