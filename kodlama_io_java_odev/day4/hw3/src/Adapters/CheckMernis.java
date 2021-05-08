package Adapters;

import Abstract.IMernisService;
import Entities.Gamer;
import MernisService.FDQKPSPublicSoap;

public class CheckMernis implements IMernisService{

    @Override
    public boolean checkGamer(Gamer gamer) throws Exception{
        FDQKPSPublicSoap client = new FDQKPSPublicSoap();

        return client.TCKimlikNoDogrula(
                Long.parseLong(gamer.getNationalityId()),
                gamer.getName().toUpperCase(),
                gamer.getSurName().toUpperCase(),
                gamer.getBirthDate().getYear()
        );
    }
}
