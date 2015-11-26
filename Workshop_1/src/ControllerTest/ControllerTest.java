package ControllerTest;

import Controller.Controller;
import Model.Game;
import Model.Player;
import View.View;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;



/**
 * Created by johanrovala on 12/11/15.
 */
public class ControllerTest {

    Player mockPlayer;
    Game mockGame;
    View mockView;
    Controller testController;

    @Before
    public void setUpMockClasses(){
        mockPlayer = mock(Player.class);
        mockGame = mock(Game.class);
        mockView = mock(View.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException(){
        new Controller(null, null, null);
    }

    @Test
    public void shouldCallGamecheckGuessAndViewReturnUserGuessOnce() {
        testController = new Controller(mockGame, mockPlayer, mockView);
        mockGame.checkGuessAndRemoveIfInWord("j");
        testController.getGuessedWordAndCallModel();
        verify(mockGame, times(1)).checkGuessAndRemoveIfInWord("j");
        verify(mockView, times(1)).returnUserGuess();
    }

    @Test
    public void ShouldCalldIsGameOverOnce(){
        testController = new Controller(mockGame, mockPlayer, mockView);
        testController.isGameOver();
        verify(mockGame, times(1)).isGameOver();
    }

    @Test
    public void shouldVerifyMethodsImplementedInPlayMethod(){
        testController = new Controller(mockGame, mockPlayer, mockView);
        testController.Play();

        // Game methods
        verify(mockGame, times(1)).isGameOver();

        // View methods
        verify(mockView, times(1)).getUserMenuInput("p");
        verify(mockView, times(1)).displayNumberOfWordsLeft(mockGame);
        verify(mockView, times(1)).getUserGuessInput("h");
    }
}