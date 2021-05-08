package Abstract;

import Entities.Game;

public interface IGameManager {
    public void addGame(Game game);
    public void removeGame(Game game);
    public void updateGame(Game game);
}
