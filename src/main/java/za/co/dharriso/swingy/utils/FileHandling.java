package za.co.dharriso.swingy.utils;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import za.co.dharriso.swingy.hero.Hero;

public class FileHandling{
    private static List<String> msg = new ArrayList<String>();

    static public String [][] getHeros(FileWriter fw){
        
        String [][] ret = {};
        int i = 0;
        int k = 0;
        try{
            for(String line: msg){
                i = 0;
                for(String value: line.split(" ")){
                    ret[k][i] = value;
                    i++;
                }
                System.out.println(k + ": " + ret[k]);
                k++;
            }
        } catch(Exception e){
            System.out.println("Error writing to file: heros.txt");
        }
        return ret;
    }

    //Add name, type, attack, defense, hitpoints, experience, level. IN THAT ORDER seperated by spaces
    static public void addToArr(Hero hero){
        String str = hero.getName() + " " + hero.getType() + " " + hero.getAttack() + " " + hero.getDefense() + " " + hero.getHitpoints() + " " + hero.getExperience() + " " + hero.getLevel();
        msg.add(str + "\n");
    }

    static public boolean checkIfHeroExists(String name, String type){
        int i = 0;
        int k = 0;
        String [][] heros = {};

        if (!msg.isEmpty()){
            for(String line: msg){
                i = 0;
                for(String value: line.split(" ")){
                    heros[k][i] = value;
                    i++;
                }
                k++;
            }
    
            k = 0;
    
            while (heros[k] != null){
                if(heros[k][0].equals(name) && heros[k][1].equals(type)){
                    return true;
                }
                k++;
            }
            return false;
        }
        else{
            return false;
        }

    }

    static public void saveHero(FileWriter fw){
        try{
            for(String line : msg){
                fw.write(line);
            }
        }
        catch(Exception e){
            System.out.println("Error saving hero: " + e);
        }
    }
}