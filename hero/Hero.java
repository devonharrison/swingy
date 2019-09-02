package hero;

import world.Coordinates;
import world.Map;

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
            case "interlect":
                this.attack = 30;
                this.defense = 50;
            case "superhuman":
                this.attack = 90;
                this.defense = 90;
            case "wizard":
                this.attack = 50;
                this.defense = 30;
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
        String drop;
        switch(villain){
            case 2:
                drop = "sweet nothing";
            case 3:
                drop = "nothing";
            case 4:
                drop = "helm";
            case 5:
                drop = "helm";
            case 6:
                drop = "weapon";
            case 7:
                drop = "armor";
            case 8:
                drop = "armor";
            default:
                drop = "";
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
}