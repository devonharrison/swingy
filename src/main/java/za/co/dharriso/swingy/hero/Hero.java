package za.co.dharriso.swingy.hero;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import za.co.dharriso.swingy.utils.GameType;
import za.co.dharriso.swingy.world.Map;
import za.co.dharriso.swingy.utils.FileHandling;

public class Hero{
    protected Map m;
    protected String name;
    protected String type;
    protected int level;
    protected int experience;
    protected int attack;
    protected int defense;
    protected int hitPoints;
    protected int longitude;
    protected int latitude;

    public String outcome;

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
        this.m = m;
        this.longitude = longitude;
        this.latitude = latitude;

        // if(FileHandling.checkIfHeroExists(name, type)){
        //     System.out.println("Hero " + name + " of type " + type + " already exists");
        // }
        // else{
            // FileHandling.addToArr(this);
        //}
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

    public String fight(int villain){
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

    protected int viewStats(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int ret = 0;
        if (GameType.gameType.equals("gui")){
            ret = 1;
        }
        else{
            System.out.println("Would you like to view your stats before choosing? (yes/no)");
            try{
                String viewStats = in.readLine().toLowerCase();
                switch(viewStats){
                    case "yes":
                        System.out.println("ATTACK: " + this.attack);
                        System.out.println("DEFENSE: " + this.defense);
                        System.out.println("HITPOINTS: " + this.hitPoints);
                        ret = 1;
                        break;
                    case "no":
                        ret = 0;
                        System.out.println("I see, element of surprise");
                }
            }
            catch(Exception e){
                System.out.println("Error reading input: " + e);
            }
        }
        return (ret);
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
            try{
                if (GameType.gameType.equals("console")){
                    System.out.println("Do we want to fight him with magic or try and get away? (fight/flight)");
                    String action = in.readLine();
                    switch(action.toLowerCase()){
                        case "flight":
                            System.out.println("You can't lose if you don't fight");
                            break;
                        case "fight":
                            System.out.println("Dammit, looks like he is quite the chunky boi...");
                            System.out.println("Attack: " + tmp[longi][lati] * 5 + "\nDefense: " + tmp[longi][lati] * 10);
                            outcome = this.fight(tmp[longi][lati]);
                            if (outcome == "win"){
                                System.out.print("He dropped a " + this.dropFromVillain(tmp[longi][lati]) + "!\n");
                                System.out.println("I think we should pick it up? (pickup/nah)");
                                action = in.readLine();
                                updateExperience(tmp[longi][lati]);
                                if (action.toLowerCase().equals("pickup")){
                                    heroStatsChange(this.dropFromVillain(tmp[longi][lati]));
                                }
                                else{
                                    System.out.println("I guess we don't need it");
                                }
                            }
                            else{
                                System.out.println("=============== YOU DIED YOU FOOL ===============");
                                FileHandling.addToArr(this);
                                System.exit(0);
                            }
                            break;
                    }
                }
                else{
                    
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

    public void updateExperience(int enemy){
        if (enemy > 1 && enemy < 10){
            this.experience = this.experience + (enemy * 30);
        }
        else{
            this.experience = this.experience + 100;
        }
        switch(this.experience){
            case 1000:
                this.level++;
                break;
            case 2450:
                this.level++;
                break;
            case 4800:
                this.level++;
                break;
            case 8050:
                this.level++;
                break;
            case 12200:
                this.level++;
                break;
        }
    }

        public int updatePostion(String move){
        String direction = move.toLowerCase();
        if (GameType.gameType.equals("console")){
            this.checkPosition(direction);
        }
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
            if (GameType.gameType.equals("console")){
                System.out.println("OH NO! Looks like we have encounted a not so nice guy...");
                this.viewStats();
                this.fightHandler(direction);
            }
            else{
                return (1);
            }
        }
        else{
            System.out.println("I don't see anything to the " + direction);
        }
        return (0);
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public int getAttack(){
        return this.attack;
    }

    public int getDefense(){
        return this.defense;
    }

    public int getHitpoints(){
        return this.hitPoints;
    }

    public int getExperience(){
        return this.experience;
    }

    public int getLevel(){
        return this.level;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public void setHitpoints(int hitpoints){
        this.hitPoints = hitpoints;
    }

    public void setExperince(int xp){
        this.experience = xp;
    }

    public void setLevel(int level){
        this.level = level;
    }
}