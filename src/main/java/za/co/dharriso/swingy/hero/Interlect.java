package za.co.dharriso.swingy.hero;

import za.co.dharriso.swingy.world.Map;

public class Interlect extends Hero implements Action{
    Interlect(String name, String type, int longitude, int latitude, Map m){
        super(name, type, longitude, latitude, m);
    }
    public int updatePostion(String move){
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
        if (this.m.getLongitude() == 0 || this.m.getLongitude() == this.m.mapSize - 1 || this.m.getLatitude() == 0 || this.m.getLatitude() == this.m.mapSize - 1){
            return (1);
        }
        else {
            return (0);
        }
    }
    public void birthOfHero(){
        
    }

    public void checkPosition(String direction){
        
    }
}