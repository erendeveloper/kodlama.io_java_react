package Concrete;

import Abstract.ICampaignManager;
import Entities.Campaign;

public class CampaignManager implements ICampaignManager {

    @Override
    public void addCampaign(Campaign campaign) {
        System.out.println("yuzde "+campaign.getCampaignName()+" campaign'i sisteme eklendi");
    }

    @Override
    public void removeCamapign(Campaign campaign) {
        System.out.println(campaign.getCampaignName()+" campaign'i sistemden silindi");
    }

    @Override
    public void updateCampaign(Campaign campaign) {
        System.out.println(campaign.getCampaignName()+" campaign'i guncellendi");
    }
}
