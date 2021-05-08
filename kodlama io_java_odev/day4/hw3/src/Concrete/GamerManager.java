package Concrete;

import Abstract.IGamerManager;
import Abstract.IMernisService;
import Adapters.CheckMernis;
import Entities.Gamer;
import org.jetbrains.annotations.NotNull;

public class GamerManager implements IGamerManager {

    IMernisService mernisService;

    public GamerManager(IMernisService mernisService) {
        this.mernisService = mernisService;
    }

    @Override
    public void addGamer(Gamer gamer) throws Exception {
        if(mernisService.checkGamer(gamer)){
            System.out.println(gamer.getName()+" "+gamer.getSurName()+" oyuncusu sisteme eklendi");
        }
    }

    @Override
    public void removeGamer(Gamer gamer) {
        System.out.println(gamer.getName()+" sistemden silindi");
    }

    @Override
    public void updateGamer(Gamer gamer) {
        System.out.println(gamer.getName()+"'in bilgileri guncellendi");
    }
}
