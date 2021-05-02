import Concrete.CampaignManager;
import Concrete.GameManager;
import Concrete.GamerManager;
import Concrete.SaleManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gamer gamer1 = new Gamer();
		gamer1.setId(1);
		gamer1.setFirstName("Mehmet");
		gamer1.setLastName("Basrioðlu");
		gamer1.setTcNo("10001101101");
		gamer1.setBirthYear("02.05.2021");
		
	  Game rainbowSix = new Game();
	  rainbowSix.setId(1);
	  rainbowSix.setProductCategory("Action");
	  rainbowSix.setProductName("Tom Clancy's Rainbow Six® Siege");
	  rainbowSix.setUnitPrice(405.35);
	  
	  Campaign rainbowSixCamp = new Campaign();
	  rainbowSixCamp.setId(1);
	  rainbowSixCamp.setCampaignDetail("RAÝNBOW SÝX SÝEGE %10 ÝNDÝRÝM");
	  rainbowSixCamp.setDiscountAmount(10);
	  rainbowSixCamp.setGame(rainbowSix);
	  
	  GameManager oyunManager = new GameManager();
	  oyunManager.add(rainbowSix);
	  oyunManager.update(rainbowSix);
	  
	  GamerManager oyuncuManager = new GamerManager();
	  oyuncuManager.signUp(gamer1);
	  oyuncuManager.signIn(gamer1);
	  oyuncuManager.update(gamer1);
	  
	  CampaignManager  campaignManager = new CampaignManager();
	  campaignManager.addCampaign(rainbowSixCamp);
	  campaignManager.updateCampaign(rainbowSixCamp);
	  
	  SaleManager saleManager = new SaleManager();
	  saleManager.buy(rainbowSixCamp, rainbowSix, gamer1);
	  
	  
	  
	 
	  
	  
		
	}

}
