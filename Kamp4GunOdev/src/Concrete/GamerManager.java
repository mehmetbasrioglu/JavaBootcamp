package Concrete;

import Abstract.GamerService;
import Entities.Gamer;
import Utils.Validation;

public class GamerManager implements GamerService {

	@Override
	public void signUp(Gamer gamer) {
		// TODO Auto-generated method stub
		boolean validation = Validation.validate(gamer);
		if (validation == true) {
			System.out.println("ID: "+ gamer.getId() + " Registered ");
		}
		else {
			throw new IllegalStateException("Wrong Identity number");
		}
		
		
	}

	@Override
	public void signIn(Gamer gamer) {
		// TODO Auto-generated method stub
		boolean validation = Validation.validate(gamer);
		if (validation == true) {
			System.out.println("ID: "+ gamer.getId() + "Signed ");
		}
		else {
			throw new IllegalStateException("Wrong Identity number");
		}
		
	}

	@Override
	public void update(Gamer gamer) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+ gamer.getId() + " Updated infos");
		
	}

	@Override
	public void delete(Gamer gamer) {
		// TODO Auto-generated method stub
		System.out.println("ID: "+ gamer.getId() + " Deleted");
		
	}

}
