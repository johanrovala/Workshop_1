package ModelTest;

import Model.Player;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by johanrovala on 10/11/15.
 */
public class PlayerTest {
    ArrayList arrayList;

    @Before
    public void setUpMock(){
        arrayList = mock(ArrayList.class);
    }

    @Test
    public void shouldAddWordToWordList(){
        Player player = new Player();
        player.guessWord("a");
        assertEquals(true, player.guessedWords.contains("a"));
    }

    @Test
    public void shouldReturnEmptyWordList(){
        Player player = new Player();
        assertEquals(arrayList.size(), player.getGuessedWords().size());
    }

    @Test
    public void shouldReturnTheAmountOfTurns(){
        Player player = new Player();
        player.guessWord("j"); // 1
        player.guessWord("k"); // 2
        player.guessWord("m"); // 3
        assertEquals(3, player.getAmountOfTurns());
    }
}