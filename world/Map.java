package world;

import world.Coordinates;

public class Map extends Watcher{
    public  int mapSize;
    private int [][] map;
    private Coordinates coordinates;
    public Map(int level){
        this.mapSize = (level - 1) * 5 + 10 - (level % 2);
        this.coordinates = new Coordinates();
        map = new int[mapSize][mapSize];
        for(int i = 0; i < this.mapSize; i++){
            for(int k = 0; k < this.mapSize; k++){
                if (i == mapSize/2 && k == mapSize/2){
                    this.map[i][k] = 1;
                }
                else{
                    this.map[i][k] = 0;
                }
                System.out.print(this.map[i][k]);
            }
            System.out.print("\n");
        }
    }
    public int [][] getMap(){
        return(this.map);
    }
    public void updateMap(int [][] newMap){
        this.map = newMap;
    }
}