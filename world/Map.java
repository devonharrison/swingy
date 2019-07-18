package world;

public class Map{
    protected int mapSize;
    private int [][] map;
    public Map(int level){
        this.mapSize = (level - 1) * 5 + 10 - (level % 2);
        map = new int[mapSize][mapSize];
        for(int i = 0; i < mapSize; i++){
            for(int k = 0; k < this.mapSize; k++){
                this.map[i][k] = 0;
                System.out.print(k);
            }
            System.out.print(i + "\n");
        }
    }
}