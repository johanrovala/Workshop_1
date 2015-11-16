package ViewTest;

import Model.Game;
import Model.Player;
import View.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        assertEquals("Welcome to my shitty version of Hangman. /n Press 'P' to start playing or 'Q' to get out", outContent.toString());
    }

    @Test
    public void shouldReturnCurrentHangman(){
        Player player = new Player();
        Game game = new Game("jazz", player);
        View view = new View();
        game.checkGuessAndRemoveIfInWord("j");
        String test = "j";
        view.displayCorrectWords();
        assertEquals(test, outContent.toString());
    }


}