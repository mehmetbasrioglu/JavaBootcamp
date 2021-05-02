package Utils;

import Entities.Gamer;

public class Validation   {

	public static boolean validate(Gamer gamer) {
		if(gamer.getTcNo().length() > 11) {
			return false;
		}
		else if(gamer.getTcNo().length() > 0 && gamer.getTcNo().length() <= 11 && !gamer.getTcNo().startsWith("0")) {
			return true;
		}
		else {
			return false;
		}
		// TODO Auto-generated method stub
		
	}
	
}
