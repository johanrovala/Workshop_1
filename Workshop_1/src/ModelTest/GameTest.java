package ModelTest;

import Model.Game;
import Model.Player;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by johanrovala on 10/11/15.
 */
public class GameTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentException(){
        new Model.Game(null, null);
    }

    @Test
    public void shouldReturnTrueIfGameIsOver(){
        Player player = new Player();
        Game game = new Game("jazz", player);
        player.guessWord("j");
        player.guessWord("a");
        player.guessWord("z");
        // Since the player has guessed all letters correct the game should be over
        assertEquals(true, game.isGameOver());
    }
}