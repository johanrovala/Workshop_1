package Model;

import java.util.ArrayList;

/**
 * Created by johanrovala on 10/11/15.
 */
public class Player {
    public ArrayList guessedWords;
    public Player (){
        guessedWords = new ArrayList();
    }

    public void guessWord(char letter){
        guessedWords.add(letter);
    }

    public ArrayList getGuessedWords(){
        return guessedWords;
    }
}
