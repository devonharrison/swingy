package za.co.dharriso.swingy.hero;

import za.co.dharriso.swingy.world.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hero{
    protected Map m;
    protected String name;
    protected String type;
    protected int level;
    protected int experience;
    protected int attack;
    protected int defense;
    protected int hitPoints;
    protected int id;
    protected int longitude;
    protected int latitude;
    private static int idCounter = 1;

    protected Hero(String name, String type, int longitude, int latitude, Map m){
        switch(type){
            case "gaurdian":
                this.attack = 60;
                this.defense = 20;
                break;
            case "interlect":
                this.attack = 30;
                this.defense = 50;
                break;
            case "superhuman":
                this.attack = 90;
                this.defense = 90;
                break;
            case "wizard":
                this.attack = 100;
                this.defense = 100;
                break;
        }
        this.name = name;
        this.type = type;
        this.level = 1;
        this.experience = 0;
        this.hitPoints = 100;
        this.id = nextId();
        this.m = m;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    private int nextId(){
        return (Hero.idCounter++);
    }

    protected String dropFromVillain(int villain){
        String drop = "DEFAULT";
        switch(villain){
            case 2:
                drop = "sweet nothing";
                break;
            case 3:
                drop = "nothing";
                break;
            case 4:
                drop = "helm";
                break;
            case 5:
                drop = "helm";
                break;
            case 6:
                drop = "weapon";
                break;
            case 7:
                drop = "armor";
                break;
            case 8:
                drop = "armor";
                break;
        }
        return (drop);
    }

    protected String fight(int villain){
        String outcome;
        int attack = villain * 5;
        int defense = villain * 10;
        if (this.attack > defense){
            outcome = "win";
        }
        else if (this.defense < attack){
            outcome = "lose";
        }
        else{
            outcome = "lose";
        }
        return (outcome);
    }

    protected void viewStats(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Would you like to view your stats before choosing? (yes/no)");
            try{
                String viewStats = in.readLine().toLowerCase();
                switch(viewStats){
                    case "yes":
                        System.out.println("ATTACK: " + this.attack);
                        System.out.println("DEFENSE: " + this.defense);
                        System.out.println("HITPOINTS: " + this.hitPoints);
                        break;
                    case "no":
                        System.out.println("I see, element of surprise");
                }

            }
            catch(Exception e){
                System.out.println("Error reading input: " + e);
            }
    }

    protected void fightHandler(String direction){
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
        System.out.println("Do we want to fight him with magic or try and get away? (fight/flight)");
            try{
                String action = in.readLine();
                switch(action.toLowerCase()){
                    case "flight":
                        System.out.println("You can't lose if you don't fight");
                        break;
                    case "fight":
                        System.out.println("Dammit, looks like he is quite the chunky boi...");
                        System.out.println("Attack: " + tmp[longi][lati] * 5 + "\nDefense: " + tmp[longi][lati] * 10);
                        String outcome = this.fight(tmp[longi][lati]);
                        if (outcome == "win"){
                            System.out.print("He dropped a " + this.dropFromVillain(tmp[longi][lati]) + "!\n");
                            System.out.println("I think we should pick it up? (pickup/nah)");
                            action = in.readLine();
                            if (action.toLowerCase().equals("pickup")){
                                heroStatsChange(this.dropFromVillain(tmp[longi][lati]));
                            }
                            else{
                                System.out.println("I guess we don't need it");
                            }
                        }
                        else{
                            System.out.println("=============== YOU DIED YOU FOOL ===============");
                            System.exit(0);
                        }
                        break;
                }
            }
            catch(Exception e){
                System.out.print("Error trying to read action: " + e);
            }
    }
    public void heroStatsChange(String artifact){
        switch (artifact.toLowerCase()){
            case "weapon":
                this.attack = this.attack + 10;
                break;
            case "armor":
                this.hitPoints = this.hitPoints + 10;
                break;
            case "helm":
                this.defense = this.defense + 10;
                break;
        }
    }
}