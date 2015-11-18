package ViewTest;

import Model.Game;
import Model.Player;
import View.View;
import View.Printer;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

import java.io.*;
import java.util.List;


/**
 * Created by johanrovala on 12/11/15.
 */
public class ViewTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Printer printer;

    @Before
    public void setUpStreams() {
        printer = mock(Printer.class);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


    @Test
    public void shouldDisplayTheCorrectWelcomeMessage(){
        View view = new View(printer);
        view.displayWelcomeMessage();
        verify(printer, times(1)).println("Welcome to my shitty version of Hangman. /n Press '1' to start playing or '2' to get out");
       // assertEquals("Welcome to my shitty version of Hangman. /n Press '1' to start playing or '2' to get out", outContent.toString());
    }


    /*
        The following test used dummy data in order to make sure that the user input method is working.
        Actual implementation will change later.
     */

    @Test
    public void shouldReturnTheUserInputIfGetUserMenuInputMethodWorks(){
        String testData = "1";
        View view = new View(printer);
        view.getUserMenuInput(testData);
        assertEquals(view.returnUserMenuChoice(), outContent.toString());
    }

    @Test
    public void shouldReturnErrorMessageWhenGivenBadUserInput(){
        View view = new View(printer);
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
        View view = new View(printer);
        game.checkGuessAndRemoveIfInWord("j");
        game.checkGuessAndRemoveIfInWord("a");
        view.displayNumberOfWordsLeft(game);
        assertEquals("_ _ ", outContent.toString());
    }

    @Test
    public void shouldTestIfUserGuessInputAndScannerWorksCorrectly(){
        View view = new View(printer);
        String testData3 = "j";
        view.getUserGuessInput(testData3);
        assertEquals(outContent.toString(), view.returnUserGuess());
    }

    @Test
    public void shouldCheckUserInputForWord(){

    }
}