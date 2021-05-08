package Abstract;

import Entities.Campaign;

public interface ICampaignManager {
    public void addCampaign(Campaign campaign);
    public void removeCamapign(Campaign campaign);
    public void updateCampaign(Campaign campaign);
}
