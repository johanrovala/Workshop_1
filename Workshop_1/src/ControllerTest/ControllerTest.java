package ControllerTest;

import Controller.Controller;

import static org.mockito.Mockito.*;

import Model.Game;
import Model.Player;
import View.View;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by johanrovala on 12/11/15.
 */
public class ControllerTest {

    Player mockPlayer;
    Game mockGame;
    View mockView;

    @Before
    public void setUpShit(){
        mockPlayer = mock(Player.class);
        mockGame = mock(Game.class);
        mockView = mock(View.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException(){
        new Controller(null, null, null);
    }

    @Test
    public void shouldCallMethodInGameAndViewOnce(){
        Controller controller = new Controller(mockGame, mockPlayer, mockView);
        controller.getGuessedWordAndCallModel();
        verify(mockGame, times(1)).checkGuessAndRemoveIfInWord("j");
        verify(mockView, times(1)).returnUserGuess();
    }

}