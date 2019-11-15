package za.co.dharriso.swingy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import za.co.dharriso.swingy.hero.Hero;
import za.co.dharriso.swingy.hero.Legion;
import za.co.dharriso.swingy.utils.CheckHeroState;
import za.co.dharriso.swingy.utils.FileHandling;
import za.co.dharriso.swingy.utils.GameType;
import za.co.dharriso.swingy.views.GamePlayForm;
import za.co.dharriso.swingy.world.Map;

public class Swingy{
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static String gameType;

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
            gameType = args[0].toLowerCase();
            new CheckHeroState(0, 0);
            new GameType(gameType);

            File file = new File("heros.txt");
            FileWriter fw = new FileWriter(file, true);
            Hero hero = null;
            new FileHandling();

            if (gameType.equals("console")){
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String type = "";
                String name = "";
                Map m = null;
                System.out.println(CYAN + "Welcome to Swingy in its console form !");
                System.out.println("Do you want to create a new hero or carry on from last time? (new/load)");
                String gameSave = in.readLine();
                if (gameSave.toLowerCase().equals("new")){
                    System.out.println(GREEN + "To begin, create your own hero by selecting one of the following hero types: Guardian, Interlect, SuperHuman, Wizard");
                    System.out.print(WHITE + "Hero type: ");
                    m = new Map(1);
                    type = in.readLine();
                    System.out.println(GREEN + "You need to give your hero a name too, something cool perhaps?");
                    System.out.print(WHITE + "Hero name: ");
                    name = in.readLine();
                    try{
                        hero = new Legion().newHero(name, type.toLowerCase(), 5, 5, m);
                    }
                    catch(Exception e){
                        System.out.println("Error creating hero: " + e);
                    }
                }
                else if(gameSave.toLowerCase().equals("load")){
                    try{
                        BufferedReader readFile = new BufferedReader(new FileReader("./heros.txt"));
                        FileHandling.listHeros(readFile);
                        System.out.println("Which hero would you like to select? (Insert name, case sensitive)");
                        String heroName = in.readLine();
                        FileHandling.getHero(heroName);
                        readFile.close();
                    }
                    catch(Exception e){
                        System.out.println("Error loading heros: " + e);
                    }
                }
                else{
                    System.out.println("Can you not read? 'new' or 'load'..");
                }
                try{

                    String move = in.readLine();
                    int run = hero.updatePostion(move);
                    while (run == 0){
                        move = in.readLine();
                        run = hero.updatePostion(move);
                        if (run == 1){
                            FileHandling.saveHero(fw);
                            System.out.println("==================== YOU WON ====================");
                            fw.close();
                            System.exit(0);
                        }
                    }
                } catch(Exception e){
                    System.out.print(e);
                }

            }
            if (gameType.equals("gui")){
                GamePlayForm sg = new GamePlayForm();
                sg.setVisible(true);
                sg.setLocationRelativeTo(null);
            }
        }
    }
}