/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Drew
 */
public class Game {
    //stores general information relating to the overall game

    private String lastSavedTime; //would probably be in a different format.
    private String gameDifficulty;
    private String language;

    private String charName;
    private String charRace;
    private int charHitPoints;
    
    public void beginGame() {
        //GameCharacter player = new GameCharacter();
        //randomly generates terrain (but not yet visible)
        
         
        GraphicalUserInterface gui = new GraphicalUserInterface();
        gui.startUpQuestions();
        gui.askCharacterTraits();
        GameCharacter player = new GameCharacter(charName,charRace,charHitPoints);
        GameBoard board = new GameBoard(gameDifficulty);
        
        gui.showBoard();
    }

    public void saveGame() {
        //saves game and stores current time in lastSavedTime
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDifficulty(String difficulty) {
        gameDifficulty = difficulty;
    }

    public String getDifficulty() {
        return gameDifficulty;
    }
}
