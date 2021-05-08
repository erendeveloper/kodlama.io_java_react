package Entities;

public class Campaign {
    private int id;
    private String campaignName;
    private float discountPercentage;

    public Campaign(int id, float discountPercentage) {
        this.id = id;
        this.campaignName = Float.toString(discountPercentage)+" indirim";
        this.discountPercentage = discountPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
