package hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import hero.Action;
import hero.Hero;
import world.Coordinates;
import world.Map;

public class Wizard extends Hero implements Action{
    Wizard(String name, String type, int longitude, int latitude, Map m){
        super(name, type, longitude, latitude, m);
    }
    public void updatePostion(String move){
        String direction = move.toLowerCase();
        switch(direction){
            case "north":
                System.out.println("LONGITUDE: " + this.m.getLongitude() + " LATITUDE: " +this.m.getLatitude());
                this.m.updateMap(this.m.getLongitude() - 1, this.m.getLatitude());
                break;
            case "east":
                System.out.println("LONGITUDE: " + this.m.getLongitude() + " LATITUDE: " +this.m.getLatitude());
                this.m.updateMap(this.m.getLongitude(), this.m.getLatitude() + 1);
                break;
            case "south":
                System.out.println("LONGITUDE: " + this.m.getLongitude() + " LATITUDE: " +this.m.getLatitude());
                this.m.updateMap(this.m.getLongitude() + 1, this.m.getLatitude());
                break;
            case "west":
                System.out.println("LONGITUDE: " + this.m.getLongitude() + " LATITUDE: " +this.m.getLatitude());
                this.m.updateMap(this.m.getLongitude(), this.m.getLatitude() - 1);
                break;
        }
    }
    public void birthOfHero(){
        System.out.println("I am here to save you");
        System.out.print(this.name + " " + this.type + " " + this.id + " " + this.attacked + "\n");
    }

    // private void changePosition(Coordinates coordinates){
    //     int [][] temp = this.m.getMap();
    //     for (int i = 0; i < this.m.mapSize; i++){
    //         for (int k = 0; k < this.m.mapSize; k++){
    //             if (temp[i][k] == 1){
    //                 temp[i][k] = 0;
    //             }
    //             if (i == coordinates.getLongitude() && k == coordinates.getLatitude()){
    //                 temp[i][k] = 1;
    //             }
    //             System.out.print(this.m.getMap()[i][k]);
    //         }
    //         System.out.print("\n");
    //     }
    //     this.m.updateMap(temp);
    // }
}