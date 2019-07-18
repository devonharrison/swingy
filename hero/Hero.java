package hero;

public class Hero{
    protected Hero(String name, String type){
        this.name = name;
        this.type = type;
        this.level = 1;
        this.experience = 0;
        this.attacked = 0;
        this.defense = 0;
        this.hitPoints = 0;
        this.id = nextId();
    }
    protected String name;
    protected String type;
    protected int level;
    protected int experience;
    protected int attacked;
    protected int defense;
    protected int hitPoints;
    protected int id;
    private static int idCounter = 1;
    private int nextId(){
        return (Hero.idCounter++);
    }
}