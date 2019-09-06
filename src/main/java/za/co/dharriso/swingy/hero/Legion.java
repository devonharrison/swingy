package za.co.dharriso.swingy.hero;

import za.co.dharriso.swingy.utils.CustomException;
import za.co.dharriso.swingy.world.Map;

public class Legion{
    public Action newHero(String name, String type, int longitude, int latitude, Map m) throws CustomException{
        if (type.equals("guardian")){
            return(new Guardian(name, type, longitude, latitude, m));
        }
        else if (type.equals("interlect")){
            return(new Interlect(name, type, longitude, latitude, m));
        }
        else if (type.equals("superhuman")){
            return(new SuperHuman(name, type, longitude, latitude, m));
        }
        else if (type.equals("wizard")){
            return(new Wizard(name, type, longitude, latitude, m));
        }
        else{
            throw new CustomException("[ERROR] Invalid hero type");
        }
    }
}