package Model;


import java.util.ArrayList;

/**
 * Created by johanrovala on 10/11/15.
 */
public class Game {
    String word;
    Player test_player;
    public ArrayList<String> wordsLeft;

    public Game (String chosenWord, Player m_player)throws IllegalArgumentException{
        if (chosenWord == null || m_player == null){
                throw new IllegalArgumentException();
            } else{
                word = chosenWord;
                test_player = m_player;
                wordsLeft = new ArrayList<>();
                for (int i = 0; i < word.length(); i++){
                    wordsLeft.add(Character.toString(word.charAt(i)));
                }

            }
    }

    public boolean isGameOverTwo(){
        System.out.println(wordsLeft.toString());
        return wordsLeft.isEmpty();
    }

    public void checkGuessAndRemoveIfInWord(String letter){
        test_player.guessWord(letter);
        for (int i = 0; i <= wordsLeft.size(); i++){
            if (wordsLeft.contains(letter)){
                wordsLeft.remove(letter);
            }
        }
    }


}
