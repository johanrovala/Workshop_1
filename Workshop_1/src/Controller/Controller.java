package Controller;

import Model.Game;
import Model.Player;
import View.View;


/**
 * Created by johanrovala on 11/11/15.
 */

public class Controller {
    Game m_game;
    Player m_player;
    View m_view;

    public Controller(Game game, Player player, View view) throws IllegalArgumentException{
        if (game == null || player == null || view == null){
            throw new IllegalArgumentException();
        }
        m_game = game;
        m_player = player;
        m_view = view;
    }

    public void getGuessedWordAndCallModel(){
        m_game.checkGuessAndRemoveIfInWord(m_view.returnUserGuess());
    }

    public boolean isGameOver(){
        return m_game.isGameOver();
    }



}
