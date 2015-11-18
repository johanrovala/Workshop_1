package ControllerTest;

import Controller.Controller;

import static org.mockito.Mockito.*;

import org.junit.Test;



/**
 * Created by johanrovala on 12/11/15.
 */
public class ControllerTest {


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException(){
        new Controller(null, null, null);
    }



}