package Abstract;


import Entities.Gamer;

public interface IGamerManager {

    public void addGamer(Gamer gamer) throws Exception;
    public void removeGamer(Gamer gamer);
    public void updateGamer(Gamer gamer);
}
