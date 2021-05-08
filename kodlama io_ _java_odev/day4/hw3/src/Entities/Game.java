package Entities;

public class Game {
    private int id;
    private String gameName;
    private float price;

    public Game(int id, String gameName, float price) {
        this.setId(id);
        setGameName(gameName);
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
