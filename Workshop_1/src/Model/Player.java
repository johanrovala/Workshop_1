package Model;

import java.util.ArrayList;

/**
 * Created by johanrovala on 10/11/15.
 */
public class Player {


    public ArrayList<String> guessedWords;


    public Player (){
        guessedWords = new ArrayList();
    }

    public void guessWord(String letter){
        guessedWords.add(letter);
    }

    public ArrayList getGuessedWords(){
        return guessedWords;
    }

    public int getAmountOfTurns(){
        return guessedWords.size();
    }
}
