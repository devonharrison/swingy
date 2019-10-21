package za.co.dharriso.swingy.hero;

import za.co.dharriso.swingy.world.Map;

public class Wizard extends Hero{

    public int checkPosition;
    public int view;

    Wizard(String name, String type, int longitude, int latitude, Map m){
        super(name, type, longitude, latitude, m);
    }
}