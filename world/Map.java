package world;

import utils.CustomException;
import world.Coordinates;
import java.util.Random;

public class Map extends Watcher{
    public  int mapSize;
    private int [][] map;
    protected int longitude;
    protected int latitude;

    // ####################
    // constructor only called once either when character is 
    // selected or new character is made, will calculate the
    // map size based on the characters level
    // ####################
    public Map(int level){
        this.mapSize = (level - 1) * 5 + 10 - (level % 2);
        this.longitude = this.mapSize/2;
        this.latitude = this.mapSize/2;
        map = new int[mapSize][mapSize];
        for(int i = 0; i < this.mapSize; i++){
            for(int k = 0; k < this.mapSize; k++){
                if (i == mapSize/2 && k == mapSize/2){
                    this.map[i][k] = 1;
                }
                else{
                    this.map[i][k] = 0;
                }
                //System.out.print(this.map[i][k]);
            }
            //System.out.print("\n");
        }
        this.generateEnemies();
    }

    // ####################
    // map functions
    // ####################
    public int [][] getMap(){
        return(this.map);
    }
    private void resetMap(){
        int [][] tmp = this.map;
        this.map = new int [this.mapSize][this.mapSize];

        for (int i = 0; i < this.mapSize; i++){
            for(int k = 0; k < this.mapSize; k++){
                if (tmp[i][k] > 1){
                    this.map[i][k] = tmp[i][k];
                }
                else{
                    this.map[i][k] = 0;
                }
            }
        }
    }
    public void updateMap(int longitude, int latitude){
        resetMap();
        this.longitude = longitude;
        this.latitude = latitude; 
        for(int i = 0; i < this.mapSize; i++){
            for(int k = 0; k < this.mapSize; k++){
                if (i == longitude && k == latitude){
                    this.map[i][k] = 1;
                }
                System.out.print(this.map[i][k]);
            }
            System.out.print("\n");
        }
    }

    // ####################
    // coordinate functions
    // ####################
    public int getLongitude(){
        return (this.longitude);
    }
    public int getLatitude(){
        return (this.latitude);
    }

    // ####################
    // function to check what the player encounters,
    // if it's an enemy, edge of the map (then they win),
    // could find artifacts along the way
    // ####################
 

    
    // ####################
    // function to randomly generate where enemies and 
    // artifacts can be found, number of enemies and 
    // artifacts are based on the mapsize (bigger map == more enemies and artifacts)
    // ####################

    protected void generateEnemies(){
        for (int i = 0; i < this.mapSize; i++){
            int longi = getRandomNum(this.mapSize);
            int lati = getRandomNum(this.mapSize);
            for (int k = 0; k < this.mapSize; k++){
                if (i == longi && k == lati){
                    this.map[i][k] = 2;
                }
                System.out.print(this.map[i][k]);
            }
            System.out.print("\n");
        }
    }

    protected int getRandomNum(int max){
        Random r = new Random();
        return (r.nextInt(max));
    }
}