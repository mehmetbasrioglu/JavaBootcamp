package Kamp5GunOdev.dataAccess.concretes;

import Kamp5GunOdev.dataAccess.abstracts.UserDao;
import Kamp5GunOdev.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
		System.out.println("Baþarýyla Eklendi");
		
	}
	@Override
	public boolean isValid(String valid,User user) {
		if(valid == user.getVerificationCode()) {
			user.setIsVerified(true);
			System.out.println("KOD ONAYLANDI");
			return true;
		}
		System.out.println("KOD ONAYLANMADI");
		return false;
		
	}
	

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
		System.out.println("Baþarýyla Silindi");
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		System.out.println("Baþarýyla Güncellendi");
		
	}

}
