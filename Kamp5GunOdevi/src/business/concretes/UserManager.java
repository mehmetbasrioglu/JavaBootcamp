package business.concretes;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	private UserDao useDao;
	
	
	public UserManager(UserDao useDao) {
		super();
		this.useDao = useDao;
		
	}
	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		if(isValid(user) && !ifEmailExists(user)) {
			useDao.add(user);
			return;
		}
		
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		if(isValid(user) && !ifEmailExists(user)) {
			useDao.update(user);
			return;
		}
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		useDao.delete(user);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return useDao.getAll();
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return useDao.get(id);
	}
	
	private boolean isValid(User user) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());
        
		if(user.getFirstName() == null || user.getLastName() == null 
				|| user.getEmail() == null || user.getPassword() == null ) {
			System.out.println("Boþ Býrakýlamaz");
			return false;
		}
		else {
			if(!matcher.matches()) {
				System.out.println("E-mail Hatalý");
				return false;
			}

			else {
				if(user.getFirstName().length() < 2 && user.getLastName().length() < 2) {
					if(user.getPassword().length() < 6 ) {
						System.out.println("Þifreniz en az 6 haneli olmalýdýr.");
						return false;
					}
				}
				
			}
		}
		return true;
	}
	
	public  boolean ifEmailExists(User user) {
		return useDao.isMailMatch(user);
	}
	
	
	public boolean ifPasswordExists(User user) {
		
		return useDao.isPasswordMatch(user);
		
	}
	
	


	
}
