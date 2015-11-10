package Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by johanrovala on 10/11/15.
 */
public class GameTest {

    @Test(expected = IllegalArgumentException.class)
    public void test(){
        new Model.Game(null);
    }
}