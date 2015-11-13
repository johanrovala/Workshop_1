package Controller;

import Model.Game;
import Model.Player;


/**
 * Created by johanrovala on 11/11/15.
 */
public class Controller {
    Game m_game;
    Player m_player;

    public Controller(Game game, Player player) throws IllegalArgumentException{
        if (game == null || player == null){
            throw new IllegalArgumentException();
        }
        m_game = game;
        m_player = player;
    }


}
