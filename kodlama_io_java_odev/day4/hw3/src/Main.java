import Adapters.CheckMernis;
import Concrete.CampaignManager;
import Concrete.GameManager;
import Concrete.GamerManager;
import Concrete.SalesManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {

        //Gamer
        GamerManager gamerManager=new GamerManager(new CheckMernis());

        Gamer gamer=new Gamer(1,"EREN","AYDIN","01234567890", LocalDate.of(2000,1,1));

        gamerManager.addGamer(gamer);

        //Game
        GameManager gameManager=new GameManager();

        Game game=new Game(1,"Maryo",100f);

        gameManager.addGame(game);

        //Campaign
        Campaign campaign=new Campaign(1,10f);

        CampaignManager campaignManager=new CampaignManager();

        campaignManager.addCampaign(campaign);

        //Sale

        SalesManager salesManager=new SalesManager();

        salesManager.sell(gamer,game,campaign);

    }
}
