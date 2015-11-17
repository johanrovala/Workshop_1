package ViewTest;

import Model.Game;
import Model.Player;
import View.View;

import mockit.integration.junit4.JMockit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 * Created by johanrovala on 12/11/15.
 */
@RunWith(JMockit.class)
public class ViewTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
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