package View;

import Model.Game;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by johanrovala on 10/11/15.
 */
public class View {

    String userMenuChoice;

    // Merely for testing purposes

    private InputStream systemIn;

    public void displayWelcomeMessage(){
        System.out.print("Welcome to my shitty version of Hangman. /n Press '1' to start playing or '2' to get out");
    }

    public void getUserMenuInput(String testData){
        systemIn = System.in;
        try{
            System.setIn(new ByteArrayInputStream(testData.getBytes()));
            Scanner scanner = new Scanner(System.in);
            userMenuChoice = testData;
            System.out.print(scanner.nextLine());
        }finally {
            System.setIn(systemIn);
        }
    }

    public String returnUserMenuChoice(){
        if(userMenuChoice == "1" || userMenuChoice == "2"){
            return userMenuChoice;
        }
        return "sry";
    }

    public void displayNumberOfWordsLeft(Game game){
        String toPrint = "";
        for (int i = 0; i < game.wordsLeft.size(); i++){
            toPrint += "_ ";
        }
        System.out.print(toPrint);
    }



}
