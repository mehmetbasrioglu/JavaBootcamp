package Concrete;

import Abstract.GameService;
import Entities.Game;
import Entities.Gamer;

public class GameManager implements GameService {

	@Override
	public void add(Game game) {
		// TODO Auto-generated method stub
		System.out.println("Game Added :  " + game.getProductName());
		
	}

	@Override
	public void delete(Game game) {
		// TODO Auto-generated method stub
		System.out.println("Game Deleted :  " + game.getProductName());
		
	}

	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		System.out.println("Game Updated :  " + game.getProductName());
		
	}

	
}
