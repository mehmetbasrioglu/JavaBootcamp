package Abstract;

import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public interface SaleService {
	void buy(Campaign campaign, Game game, Gamer gamer);
	void refund(Game game, Gamer gamer);
}
