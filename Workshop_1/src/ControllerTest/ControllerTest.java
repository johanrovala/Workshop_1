package ControllerTest;

import Controller.Controller;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by johanrovala on 12/11/15.
 */
public class ControllerTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException(){
        new Controller(null, null);
    }

}