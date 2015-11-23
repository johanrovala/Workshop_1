import Controller.Controller;
import Model.Game;
import Model.Player;
import View.View;
import View.Printer;


/**
 * Created by johanrovala on 23/11/15.
 */
public class Main {
    public static void main(String[] args){
        Printer printer = new Printer();
        Player player = new Player();
        Game game = new Game("jazz", player);
        View view = new View(printer);
        Controller controller = new Controller(game, player, view);

        while(!controller.isGameOver()){

        }

    }
}
