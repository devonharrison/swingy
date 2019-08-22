package hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import hero.Action;
import hero.Hero;
import world.Coordinates;
import world.Map;

public class Interlect extends Hero implements Action{
    Interlect(String name, String type, Coordinates coordinates, Map m){
        super(name, type, coordinates, m);
    }
    public void updatePostion(String move){
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // String type = in.readLine();

    }
    public void birthOfHero(){
        
    }
}