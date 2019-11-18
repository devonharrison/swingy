package za.co.dharriso.swingy.controller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import za.co.dharriso.swingy.controller.Hero;
import za.co.dharriso.swingy.controller.Legion;
import za.co.dharriso.swingy.controller.Map;

public class FileHandling{
    private static List<String> msg = new ArrayList<String>();

    static public void listHeros(BufferedReader readFile){
        try{
            String str;
            while ((str = readFile.readLine()) != null) {
                msg.add(str);
                System.out.println(str);
            }
        }
        catch(Exception e){
            System.out.println("Error reading file: " + e);
        }
    }

    //Add name, type, attack, defense, hitpoints, experience, level. IN THAT ORDER seperated by spaces
    static public void addToArr(Hero hero){
        String str = hero.getName() + " " + hero.getType() + " " + hero.getAttack() + " " + hero.getDefense() + " " + hero.getHitpoints() + " " + hero.getExperience() + " " + hero.getLevel();
        
        if (!msg.isEmpty()){
            for (String line : msg){
                String [] tmp = line.split(" ");
                if (tmp[0].equals(hero.getName()) && tmp[1].equals(hero.getType())){
                    msg.remove(line);
                    msg.add(str + "\n");
                }
            }
        }
        else{
            msg.add(str + "\n");
        }
    }

    static public void removeFromArr(Hero hero){
        for (String line : msg){
            String [] tmp = line.split(" ");
            if (tmp[0].equals(hero.getName()) &&
            (tmp[1].equals(hero.getType())) &&
            (Integer.parseInt(tmp[2]) == (hero.getAttack())) &&
            (Integer.parseInt(tmp[3]) == (hero.getDefense())) &&
            (Integer.parseInt(tmp[4]) == (hero.getHitpoints())) &&
            (Integer.parseInt(tmp[5]) == (hero.getExperience())) &&
            (Integer.parseInt(tmp[6]) == (hero.getLevel()))){
                msg.remove(line);
            }
        }
    }

    static public boolean checkIfHeroExists(String name, String type){
        if (!msg.isEmpty()){
            String [] tmp;
            for(String line : msg){
                tmp = line.split(" ");
                if (tmp[0].equals(name) && tmp[1].equals(type)){
                    return true;
                }
            }
        }
        return false;
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

    static public Hero getHero(String name){
        Hero hero = null;
        for (String line : msg){
            String [] tmp = line.split(" ");
            if (tmp[0].equals(name)){
                String type = tmp[1];
                int level = Integer.parseInt(tmp[6]);
                Map m = new Map(level);
                int startPoint = m.mapSize/2;
                try{
                    hero = new Legion().newHero(name, type, startPoint, startPoint, m);
                    hero.setAttack(Integer.parseInt(tmp[2]));
                    hero.setDefense(Integer.parseInt(tmp[3]));
                    hero.setHitpoints(Integer.parseInt(tmp[4]));
                    hero.setExperince(Integer.parseInt(tmp[5]));
                }
                catch(Exception e){
                    System.out.println("Error creating hero: 1" + e);
                }
                break;
            }
        }
        return hero;
    }
}