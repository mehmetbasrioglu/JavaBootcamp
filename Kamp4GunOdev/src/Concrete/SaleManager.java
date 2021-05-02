package Concrete;

import Abstract.SaleService;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class SaleManager implements SaleService{

	@Override
	public void buy(Campaign campaign, Game game, Gamer gamer) {
		// TODO Auto-generated method stub
		System.out.println("New Game sold: "+ campaign.getUnitPriceAfterDiscount() + " TL " + " " + game.getProductName()+ " ID : " + gamer.getId());
		
	}

	@Override
	public void refund(Game game, Gamer gamer) {
		// TODO Auto-generated method stub
		
	}

}
