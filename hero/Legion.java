package hero;

import hero.Hero;
import utils.CustomException;

public class Legion{
    public Action newHero(String name, String type, int longitude, int latitude) {
        Coordinates coordinates = new Coordinates(longitude, latitude);
        if (type.equals("Guardian")){
            return(new Guardian(name, type));
        }
        else if (type.equals("Interlect")){
            return(new Interlect(name, type));
        }
        else if (type.equals("Super")){
            return(new Super(name, type));
        }
        else if (type.equals("Wizard")){
            return(new Wizard(name, type));
        }
        else{
            throw new CustomException("[ERROR] Invalid hero type");
        }
    }
}