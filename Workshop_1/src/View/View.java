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
    String userGuess;
    String userWord;
    Printer printer;
    // Merely for testing purposes

    public View (Printer printer){
        this.printer = printer;
    }

    private InputStream systemIn;

    public void displayWelcomeMessage(){
        printer.println("Welcome to my shitty version of Hangman. /n Press '1' to start playing or '2' to get out");
    }

    public void getUserMenuInput(String testData){
        systemIn = System.in;
        try{
            System.setIn(new ByteArrayInputStream(testData.getBytes()));
            Scanner scanner = new Scanner(System.in);
            userMenuChoice = testData;
            printer.println(scanner.nextLine());
        }finally {
            System.setIn(systemIn);
        }
        /*
        Scanner scanner = new Scanner(System.in);
        userGuess = scanner.next();
         */
    }

    public void setUserWord(String string){
        userWord = string;
    }

    public String getUserWord(){
        return userWord;
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
        printer.println(toPrint);
    }

    public void getUserGuessInput(String testData){
        systemIn = System.in;
        try{
            System.setIn(new ByteArrayInputStream(testData.getBytes()));
            Scanner scanner = new Scanner(System.in);
            userGuess = testData;
            printer.println(scanner.nextLine());
        }finally {
            System.setIn(systemIn);
        }
        /*
        Scanner scanner = new Scanner(System.in);
        userGuess = scanner.next();
        */
    }

    public String returnUserGuess(){
        return userGuess;
    }



}
