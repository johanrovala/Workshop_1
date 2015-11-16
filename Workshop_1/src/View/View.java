package View;

import Model.Game;
import Model.Player;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by johanrovala on 10/11/15.
 */
public class View {

    String userMenuChoice;
    String viewCorrectWords;

    // Merely for testing purposes

    private InputStream systemIn;

    public void displayWelcomeMessage(){
        System.out.print("Welcome to my shitty version of Hangman. /n Press 'P' to start playing or 'Q' to get out");
    }

    public void getUserMenuInput(String testData){
        systemIn = System.in;
        try{
            System.setIn(new ByteArrayInputStream(testData.getBytes()));
            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.nextLine());
        }finally {
            System.setIn(systemIn);
        }
    }

    public String returnUserMenuChoice(){
        return userMenuChoice;
    }

    public void displayCorrectWords(Game game){
        System.out.print(game.wordsLeft.toString());
    }



}
