
package lab2;

/**
 *
 * @author Drew
 */
public class GraphicalUserInterface {

    private boolean displayBoard;
    private boolean displayCharacter;
    //switches display to fightScreen (not used currently)
    private boolean displayFightScreen;

    public GraphicalUserInterface() {
        //Code that activates GUI

        //initialize display booleans with false
        displayBoard = false;
        displayCharacter = false;
        displayFightScreen = false;
    }

    public void startUpQuestions(){
        this.askStartUpCharacteristics();
        this.askCharacterTraits();
    }
    
    //asks startup characteristics, stores in game object
    private void askStartUpCharacteristics() {
        //ask user through GUI interface for language, and difficulty of game
        //pass information by reference to the game class
        
    }

    //asks user for character traits, stores in player object
    public void askCharacterTraits() {
        //ask user through GUI interface for character traits: name, race, and hit points
        //pass the response by reference back to the game class.
    }

    public void showBoard() {
        displayBoard = true;
        displayCharacter = true;
    }
}
