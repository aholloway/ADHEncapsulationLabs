/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Drew
 */
public class GameBoard {

	private static int mapSize;
	private int numEnemies;
	private String terrainType;
	
	//constructor creates random terrain
	public GameBoard(String difficulty){
		this.setupMap();
                this.setNumEnemies(difficulty);
	}

	private static void setupMap(){
		//ideally map would be a two dimensional array with length and width set below, but 
		//for simplicity it is just an int.
		int mapLength=8; //mapLength is randomly generated length between 8 and 12
		int mapWidth=5; //mapWidth is randomly generated width between 5 and 10
		mapSize=mapLength*mapWidth;
		//terrainType is randomly generated (swamp, forest, plains, mountain, island)
	}

	public static void setNumEnemies(String difficulty){
		//generates random number of enemies based on difficulty
	}

}
