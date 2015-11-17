package ControllerTest;

import Controller.Controller;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by johanrovala on 12/11/15.
 */
@RunWith(JMockit.class)
public class ControllerTest {

    @Mocked View.View view;

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException(){
        new Controller(null, null, null);
    }

}