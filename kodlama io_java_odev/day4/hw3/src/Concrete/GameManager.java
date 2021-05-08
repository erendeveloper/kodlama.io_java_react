package Concrete;

import Abstract.IGameManager;
import Entities.Game;

public class GameManager implements IGameManager {
    @Override
    public void addGame(Game game) {
        System.out.println(game.getGameName()+" oyunu sisteme eklendi");
    }

    @Override
    public void removeGame(Game game) {
        System.out.println(game.getGameName()+" oyunu sistemden silindi");
    }

    @Override
    public void updateGame(Game game) {
        System.out.println(game.getGameName()+" oyununun bilgileri guncellendi");
    }
}
