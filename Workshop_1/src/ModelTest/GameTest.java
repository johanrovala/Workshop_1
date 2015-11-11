package ModelTest;

import Model.Game;
import Model.Player;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by johanrovala on 10/11/15.
 */
public class GameTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentException(){
        new Model.Game(null, null);
    }

    @Test
    public void shouldRemoveLetterFromListInGameClass(){
        Player player = new Player();
        Game game = new Game("jazz", player);
        game.checkGuessAndRemoveIfInWord("j");
        ArrayList<String> testList = new ArrayList<>();
        testList.add("a");
        testList.add("z");
        testList.add("z");
        assertEquals(testList, game.wordsLeft);
    }

    @Test
    public void shouldReturnFalseIfGameIsNotOver(){
        Player player = new Player();
        Game game = new Game("jazz", player);
        game.checkGuessAndRemoveIfInWord("j");
        assertEquals(false, game.isGameOver());
    }

    @Test
    public void shouldReturnTrueIfGameIsOver(){
        Player player = new Player();
        Game game = new Game("jazz", player);
        game.checkGuessAndRemoveIfInWord("j");
        game.checkGuessAndRemoveIfInWord("a");
        game.checkGuessAndRemoveIfInWord("z");
        assertEquals(true, game.isGameOver());
    }
}