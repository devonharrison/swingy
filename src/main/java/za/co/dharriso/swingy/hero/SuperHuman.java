package za.co.dharriso.swingy.hero;

import za.co.dharriso.swingy.world.Map;

public class SuperHuman extends Hero implements Action{

    public int checkPosition;
    public int view;

    SuperHuman(String name, String type, int longitude, int latitude, Map m){
        super(name, type, longitude, latitude, m);
    }
    public int updatePostion(String move){
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
        if (this.m.getLongitude() == 0 || this.m.getLongitude() == this.m.mapSize - 1 || this.m.getLatitude() == 0 || this.m.getLatitude() == this.m.mapSize - 1){
            this.updateExperience(this.m.getMap()[this.m.getLongitude()][this.m.getLatitude()]);
            return (1);
        }
        else {
            return (0);
        }
    }
    public void birthOfHero(){
        
    }

    public int checkPosition(String direction){
        
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
            System.out.println("OH NO! Looks like we have encounted a not so nice guy...\nI'll just beat him to death");
            view = this.viewStats();
            // gui gets stuck here because it's waiting for a console input to continue
            // refactor fightHandler()
            this.fightHandler(direction);
            checkPosition = 1;
        }
        else{
            System.out.println("I don't see anything to the " + direction);
            checkPosition = 0;
        }
        return (0);
    }
}