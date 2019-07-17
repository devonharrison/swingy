package hero;

public class Hero{
    protected Hero(String name, String type){
        this.name = name;
        this.type = type;
        this.id = nextId();
    }
    protected String name;
    protected String type;
    protected int id;
    private static int idCounter = 1;
    private int nextId(){
        return (Hero.idCounter++);
    }
}