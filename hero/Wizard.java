package hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import hero.Action;
import hero.Hero;
import world.Coordinates;
import world.Map;

public class Wizard extends Hero implements Action{
    Wizard(String name, String type, Coordinates coordinates, Map m){
        super(name, type, coordinates, m);
    }
    public void updatePostion(String move){
        String direction = move.toLowerCase();
        switch(direction){
            case "north":
                this.coordinates = new Coordinates(coordinates.getLongitude() - 1, coordinates.getLatitude());
                int [][] tmp = this.m.getMap();
                for (int i = 0; i < this.m.mapSize; i++){
                    for (int k = 0; k < this.m.mapSize; k++){
                        System.out.print(tmp[i][k]);
                    }
                    System.out.print("\n");
                }
            case "east":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1);
            case "south":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude());
            case "west":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() - 1);
        }
        //changePosition(this.coordinates);
    }
    public void birthOfHero(){
        System.out.println("I am here to save you");
        System.out.print(this.name + " " + this.type + " " + this.id + " " + this.attacked + "\n");
    }

    // private void changePosition(Coordinates coordinates){
    //     int [][] temp = this.getMap();
    //     for (int i = 0; i < this.mapSize; i++){
    //         for (int k = 0; k < this.mapSize; k++){
    //             if (temp[i][k] == 1){
    //                 temp[i][k] = 0;
    //             }
    //             if (i == coordinates.getLongitude() && k == coordinates.getLatitude()){
    //                 temp[i][k] = 1;
    //             }
    //         }   
    //     }
    //     this.updateMap(temp);
    // }
}