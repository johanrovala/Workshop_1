import Controller.Controller;
import Model.Game;
import Model.Player;
import View.View;
import View.Printer;

import java.util.ArrayList;


/**
 * Created by johanrovala on 23/11/15.
 */
public class Main {
    public static void main(String[] args){
        Printer printer = new Printer();
        Player player = new Player();
        Game game = new Game("jazz", player, new ArrayList());
        View view = new View(printer);
        Controller controller = new Controller(game, player, view);

        view.displayWelcomeMessage();
        view.normalGetUserMenuInput();
        System.out.println(view.returnUserMenuChoice());
        if(view.returnUserMenuChoice().equals("1")){
            while(!controller.Play()){

            }
        }else{
            System.out.println("Bye");
        }

    }
}
