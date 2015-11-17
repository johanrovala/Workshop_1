package ViewTest;

import Model.Game;
import Model.Player;
import View.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by johanrovala on 12/11/15.
 */
public class ViewTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


    @Test
    public void shouldDisplayTheCorrectWelcomeMessage(){
        View view = new View();
        view.displayWelcomeMessage();
        assertEquals("Welcome to my shitty version of Hangman. /n Press '1' to start playing or '2' to get out", outContent.toString());
    }


    /*
        The following test used dummy data in order to make sure that the user input method is working.
        Actual implementation will change later.
     */

    @Test
    public void shouldReturnTheUserInputIfGetUserMenuInputMethodWorks(){
        String testData = "1";
        View view = new View();
        view.getUserMenuInput(testData);
        assertEquals(view.returnUserMenuChoice(), outContent.toString());
    }

    @Test
    public void shouldReturnErrorMessageWhenGivenBadUserInput(){
        View view = new View();
        String testData2 = "K";
        view.getUserMenuInput(testData2);
        assertNotEquals(outContent.toString(), view.returnUserMenuChoice());
    }

    /*
        End of earlier statement
     */

    @Test
    public void shouldReturnTheNumberOfWordsThatAreLeftWithEmptyUnderscores(){
        Player player = new Player();
        Game game = new Game("jazz", player);
        View view = new View();
        game.checkGuessAndRemoveIfInWord("j");
        game.checkGuessAndRemoveIfInWord("a");
        view.displayNumberOfWordsLeft(game);
        assertEquals("_ _ ", outContent.toString());
    }

    @Test
    public void shouldTestIfUserGuessInputAndScannerWorksCorrectly(){
        View view = new View();
        String testData3 = "j";
        view.getUserGuessInput(testData3);
        assertEquals(outContent.toString(), view.returnUserGuess());
    }

}