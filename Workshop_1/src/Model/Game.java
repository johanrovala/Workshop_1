package Model;


import java.util.ArrayList;

/**
 * Created by johanrovala on 10/11/15.
 */
public class Game {
    private String word;
    private Player test_player;
    public ArrayList<String> wordsLeft;

    public Game (String chosenWord, Player m_player, ArrayList list)throws IllegalArgumentException{
        if (chosenWord == null || m_player == null){
                throw new IllegalArgumentException();
            } else{
                word = chosenWord;
                test_player = m_player;
                setWordsLeftList(list);
                for (int i = 0; i < word.length(); i++){
                    wordsLeft.add(Character.toString(word.charAt(i)));
                }
            }
    }

    public boolean isGameOver(){
        return wordsLeft.isEmpty() || test_player.getAmountOfTurns() >= 10;
    }

    public void checkGuessAndRemoveIfInWord(String letter){
        test_player.guessWord(letter);
        for (int i = 0; i <= wordsLeft.size(); i++){
            if (wordsLeft.contains(letter)){
                wordsLeft.remove(letter);
            }
        }
    }

    /*
     * Setters in order to mock the class and still get the work made in constructor
     */

    public void setPlayer(Player player){
        test_player = player;
    }

    public void setWordsLeftList(ArrayList arrayList){
        wordsLeft = arrayList;
    }


}
