package Model;

import java.util.InputMismatchException;

/**
 * Created by johanrovala on 10/11/15.
 */
public class Game {
    String word;

    public Game (String chosenWord)throws IllegalArgumentException{
        if (chosenWord == null)
            {
                throw new IllegalArgumentException();
            }
        else
            {
                word = chosenWord;
            }
    }
}
