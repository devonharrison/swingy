package hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import hero.Action;
import hero.Hero;
import world.Coordinates;

public class Interlect extends Hero implements Action{
    Interlect(String name, String type, Coordinates coordinates){
        super(name, type, coordinates);
    }
    public void updatePostion(){
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // String type = in.readLine();

    }
    public void birthOfHero(){
        
    }
}