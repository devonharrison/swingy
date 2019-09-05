package hero;

import hero.Action;
import hero.Hero;
import world.Map;

public class Wizard extends Hero implements Action{
    Wizard(String name, String type, int longitude, int latitude, Map m){
        super(name, type, longitude, latitude, m);
    }
    public void updatePostion(String move){
        String direction = move.toLowerCase();
        this.checkPosition(direction);
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
    }

    public void checkPosition(String direction){

        int longi = this.m.getLongitude();
        int lati = this.m.getLatitude();
        int [][] tmp = this.m.getMap();
        switch(direction){
            case "north":
                longi = longi - 1;
                break;
            case "east":
                lati = lati + 1;
                break;
            case "south":
                longi = longi + 1;
                break;
            case "west":
                lati = lati - 1;
                break;
        }
        if (tmp[longi][lati] > 1 && tmp[longi][lati] < 9){
            System.out.println("OH NO! Looks like we have encounted a not so nice guy...\nNothing a little magic can't take care off");
            this.viewStats();
            this.fightHandler(direction);
        }
        else{
            System.out.println("I don't see anything to the " + direction);
        }
    }
}