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
        System.out.print(this.name + " " + this.type + " " + this.id + " " + this.attack + "\n");
    }

    public void checkPosition(String direction){
        int longi = this.m.getLongitude();
        int lati = this.m.getLatitude();
        int [][] tmp = this.m.getMap();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
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
            System.out.println("OH NO! Looks like we have encounted a not so nice guy...");
            System.out.println("Do we want to fight him with magic or try and get away? (fight/flight)");
            try{
                String action = in.readLine();
                switch(action.toLowerCase()){
                    case "flight":
                        System.out.println("You can't lose if you don't fight");
                    case "fight":
                        System.out.println("Dammit, looks like he is quite the chungy boi...");
                        System.out.println("Attack: " + tmp[longi][lati] * 5 + "\nDefense: " + tmp[longi][lati] * 10);
                        String outcome = this.fight(tmp[longi][lati]);
                        if (outcome == "win"){
                            this.dropFromVillain(tmp[longi][lati]);
                            // check what artifact is picked up and adjust hero stats accordingly
                        }
                        else{
                            System.out.println("=============== YOU DIED YOU FOOL ===============");
                            System.exit(0);
                        }
                }
            }
            catch(Exception e){
                System.out.print("Error trying to read action: " + e);
            }
        }
        else if (tmp[longi][lati] == 9){
            System.out.println("I see something shiny, I think we should pick it up and see what it is...\n(pickup/nah)");
            try{
                String action = in.readLine();
                switch(action.toLowerCase()){
                    case "pickup":
                    case "nah":
                }    
            }
            catch(Exception e){
                    System.out.print("Error trying to read action: " + e);
            }
        }
        else{

        }
    }
}