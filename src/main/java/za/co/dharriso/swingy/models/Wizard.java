package za.co.dharriso.swingy.models;

import za.co.dharriso.swingy.controller.Map;
import za.co.dharriso.swingy.controller.Hero;

public class Wizard extends Hero{

    public int checkPosition;
    public int view;

    public Wizard(String name, String type, int longitude, int latitude, Map m){
        super(name, type, longitude, latitude, m);
    }
}