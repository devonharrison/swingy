package hero;

import world.Coordinates;

public class Hero{
    protected String name;
    protected String type;
    protected int level;
    protected int experience;
    protected int attacked;
    protected int defense;
    protected int hitPoints;
    protected int id;
    protected Coordinates coordinates;
    private static int idCounter = 1;
    protected Hero(String name, String type, Coordinates coordinates){
        switch(type){
            case "gaurdian":
                this.attacked = 60;
                this.defense = 20;
            case "interlect":
                this.attacked = 30;
                this.defense = 50;
            case "superhuman":
                this.attacked = 90;
                this.defense = 90;
            case "wizard":
                this.attacked = 50;
                this.defense = 30;
        }
        this.name = name;
        this.type = type;
        this.level = 1;
        this.experience = 0;
        this.hitPoints = 100;
        this.coordinates = coordinates;
        this.id = nextId();
    }
    private int nextId(){
        return (Hero.idCounter++);
    }
}