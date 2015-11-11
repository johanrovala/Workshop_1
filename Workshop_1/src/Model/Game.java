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
    public boolean isGameOver(){
        boolean check = false;
        int rightAmount = 0;
        for (int i = 0; i <= word.length()-1; i++){
            for (int j = 0; j < test_player.getGuessedWords().size(); j++){
                if(Character.toString(word.charAt(i)).equals(test_player.getGuessedWords().get(j))){
                    rightAmount++;
                }
            }
        }
        if (rightAmount == word.length()){
            check = true;
        }
        return check;
    }

    public void checkGuessAndRemoveIfInWord(String letter){
        test_player.guessWord(letter);
        wordsLeft.remove(letter);
    }


}
