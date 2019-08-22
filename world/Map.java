package world;

public class Map extends Watcher{
    public  int mapSize;
    private int [][] map;
    public Map(int level){

        this.mapSize = (level - 1) * 5 + 10 - (level % 2);
        map = new int[mapSize][mapSize];
        for(int i = 0; i < mapSize; i++){
            for(int k = 0; k < this.mapSize; k++){
                this.map[i][k] = 0;
                if (i == mapSize/2 && k == mapSize/2){
                    this.map[i][k] = 1;
                }
            }
        }
    }
    public int [][] getMap(){
        return(this.map);
    }
    public void updateMap(int [][] newMap){
        this.map = newMap;
    }
}