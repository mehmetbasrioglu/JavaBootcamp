package Abstract;

import Entities.Gamer;

public interface GamerService {
	void signUp(Gamer gamer);
	void signIn(Gamer gamer);
	
	void update(Gamer gamer);
	void delete(Gamer gamer);
	
	
}
