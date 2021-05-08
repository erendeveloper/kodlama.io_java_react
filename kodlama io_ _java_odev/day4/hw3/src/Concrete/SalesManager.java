package Concrete;

import Abstract.ISalesManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class SalesManager implements ISalesManager {
    @Override
    public void sell(Gamer gamer, Game game, Campaign campaign) {
        float oldPrice=game.getPrice();
        float newPrice=oldPrice*(100-campaign.getDiscountPercentage())/100f;

        System.out.println(gamer.getName()+" "+gamer.getSurName()+" "+
                game.getGameName()+" oyununu "+
                oldPrice+" liradan yuzde "+campaign.getDiscountPercentage()
                +" indirimle "+newPrice+" liraya satin aldi");
    }
}
