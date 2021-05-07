package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	private List<User> users;
	
	public InMemoryUserDao() {
		this.users = new ArrayList<User>();
	}

	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
		// Kullan�c� Ekle
		users.add(user);
		System.out.println("Veri taban�na Eklendi");
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
		
		// REF T�P�NE G�RE G�NCELLE SETTER YAP.
		
		
		User updatedUser = users.stream().filter(users_ -> users_.getId() == user.getId()).findFirst().get();
		
		
		updatedUser.setFirstName(user.getEmail());
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setId(user.getId());
		updatedUser.setLastName(user.getFirstName());
		updatedUser.setPassword(user.getPassword());
		
		
		
		
		
		System.out.println("Veri taban�nda g�ncellendi");
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
		// �D G�RE S�L
		
		users.remove(getById(user.getId()));
		System.out.println("Veri taban�nda silindi ");
		
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		
		// ID G�RE F�LTRELE VE GET�R
		return users.stream().filter(user_ -> user_.getId() == id).findFirst().get();
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		
		// Oldu�u gibi GLOBAL List g�nder
		return users;
	}

	@Override
	public boolean ifMailExists(User user) {
		// TODO Auto-generated method stub
		
		// EMA�L UYU�UYOR MU BAK
		return users.stream().anyMatch(x-> x.getEmail() == user.getEmail());
	}

	@Override
	public boolean ifPasswordExists(User user) {
		// TODO Auto-generated method stub
		
		// ��FRELER UYU�UYOR MU BAK
		return users.stream().anyMatch(x-> x.getPassword() == user.getPassword());
	}


	@Override
	public List<String> getEmails() {
		// TODO Auto-generated method stub
		List<String> emails = new ArrayList<String>();
		for (User users_ : users) {
			emails.add(users_.getEmail());
			
		}
		return emails;
	}


	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return users.stream().filter(x-> x.getEmail() == email).findFirst().get();
	}

}
