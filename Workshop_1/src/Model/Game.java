package Model;

import java.util.InputMismatchException;

/**
 * Created by johanrovala on 10/11/15.
 */
public class Game {
    String word;

    public Game (String chosenWord, Player m_player)throws IllegalArgumentException{
        if (chosenWord == null || m_player == null){
                throw new IllegalArgumentException();
            } else{
                word = chosenWord;
            }
    }

    public boolean isGameOver(){
        // todo
        return false;
    }


}
