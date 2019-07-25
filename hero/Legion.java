package hero;

import world.Coordinates;
import utils.CustomException;

public class Legion{
    public Action newHero(String name, String type, int longitude, int latitude) throws CustomException{
        Coordinates coordinates = new Coordinates(longitude, latitude);
        if (type.equals("guardian")){
            return(new Guardian(name, type, coordinates));
        }
        else if (type.equals("interlect")){
            return(new Interlect(name, type, coordinates));
        }
        else if (type.equals("superhuman")){
            return(new SuperHuman(name, type, coordinates));
        }
        else if (type.equals("wizard")){
            return(new Wizard(name, type, coordinates));
        }
        else{
            throw new CustomException("[ERROR] Invalid hero type");
        }
    }
}