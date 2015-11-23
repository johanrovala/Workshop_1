package ModelTest;

import Model.Game;
import Model.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by johanrovala on 10/11/15.
 */
public class GameTest {

    ArrayList arrayList;

    @Before
    public void setUpMock(){
        arrayList = mock(ArrayList.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentException(){
        new Model.Game(null, null);
    }

    @Test
    public void shouldRemoveLetterFromListInGameClass(){
        Player player = new Player();
        Game game = new Game("jazz", player);
        game.checkGuessAndRemoveIfInWord("j");
        when(arrayList.size()).thenReturn(3);
        arrayList.add("a");
        arrayList.add("z");
        arrayList.add("z");
        assertEquals(arrayList.size(), game.wordsLeft.size());
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

    @Test
    public void shouldReturnTrueIfPlayerHasHadMoreThan10Tries(){
        Player player = new Player();
        Game game = new Game("jazz", player);
        for (int i = 0; i <= 10; i++){
            game.checkGuessAndRemoveIfInWord("h");
        }
        assertEquals(true, game.isGameOver());
    }
}