
package lab2;

/**
 *
 * @author Drew
 */
public class GameCharacter {

    private String characterName;
    private String characterRace;
    private int characterHitPoints;

    public GameCharacter(String name, String race, int hitPoints) {
        //set characterName, characterRace, and characterHitPoints;
        this.setName(name);
        this.setRace(race);
        this.setHitPoints(hitPoints);
    }

    //Name cannot change, only set by constructor
    private void setName(String name) {
        //Validation
        characterName = name;
    }

    //race cannot change, only called by the constructor
    private void setRace(String race) {
        //Validation
        characterRace = race;
    }

    //public method allows characterHitPoits to change throughout game
    public void setHitPoints(int hitPoints) {
        //Validation
        characterHitPoints = hitPoints;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getCharacterRace() {
        return characterRace;
    }

    public int getCharacterHitPoints() {
        return characterHitPoints;
    }
}
