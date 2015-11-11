package Model;

import java.util.InputMismatchException;

/**
 * Created by johanrovala on 10/11/15.
 */
public class Game {
    String word;
    Player test_player;

    public Game (String chosenWord, Player m_player)throws IllegalArgumentException{
        if (chosenWord == null || m_player == null){
                throw new IllegalArgumentException();
            } else{
                word = chosenWord;
                test_player = m_player;
            }
    }

    public boolean isGameOver(){
        boolean test = false;
        int test2 = 0;
        for (int i = 0; i <= word.length()-1; i++){
            for (int j = 0; j < test_player.getGuessedWords().size(); j++){
                if(Character.toString(word.charAt(i)).equals(test_player.getGuessedWords().get(j))){
                    test2++;
                }
            }
        }
        if (test2 == word.length()){
            test = true;
        }
        return test;
    }


}
