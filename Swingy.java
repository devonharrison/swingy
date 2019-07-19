import world.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import hero.*;
import world.*;

public class Swingy{
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String [] args) throws IOException{
        int argc = args.length;
        if (argc != 1){
            if (argc < 1){
                System.out.println("Please specify tour prefered interface (GUI/console)");
            }
            else{
                System.out.println("Too many options, just one please");
            }
        }
        else{
            String gameType = args[0].toLowerCase();
            if (gameType.equals("console")){
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                //try{
                    System.out.println(CYAN + "Welcome to Swingy in its console form !");
                    System.out.println(GREEN + "To begin, create your own hero by selecting one of the following hero types: Guardian, Interlect, SuperHuman, Wizard");
                    System.out.print(WHITE + "Hero type: ");
                    try{
                            String type = in.readLine();
                            System.out.println(GREEN + "You need to give your hero a name too, something cool perhaps?");
                            System.out.print(WHITE + "Hero name: ");
                            String name = in.readLine();
                            Coordinates coordinates = new Coordinates(5, 5);
                            Action hero = new Legion().newHero(name, type.toLowerCase(), 5, 5);
                            hero.birthOfHero();
                    } catch(Exception e){
                        System.out.print(e);
                    }
                    //Map m = new Map(1);
                //} catch(Exception e){
                //    System.out.print("[ERROR]" + e);
                //}
            }
            if (gameType.equals("gui")){
                System.out.println(gameType);
            }
        }
    }
}