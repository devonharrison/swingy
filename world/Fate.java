package world;
import java.util.ArrayList;
import hero.Action;

public class Fate{
    private ArrayList<Action> observers = new ArrayList<Action>();
    public void register(Action action){
        if (observers.contains(action)){
            System.out.println("Hero already exists");
        }
        else{
            observers.add(action);
        }
    }
    public void unregister(Action action){
        if (!observers.contains(action)){
            System.out.println("Hero does not exist, a ninja perhaps?");
        }
        else{
            observers.remove(action);
        }
    }
    protected void conditionsChanged(){
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).updatePostion();
        }
        
    }
}