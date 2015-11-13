package ViewTest;

import View.View;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by johanrovala on 12/11/15.
 */
public class ViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldDisplayExpectedWelcomeMessage(){
       View view = new View();
       assertEquals("Welcome to my shitty version of Hangman. /n Press 'P' to start playing or 'Q' to get out", outContent.toString());
    }

}