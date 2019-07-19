package hero;

import hero.*;
import world.Coordinates;
import utils.CustomException;

public class Legion{
    public Action newHero(String name, String type, int longitude, int latitude) throws CustomException{
        Coordinates coordinates = new Coordinates(longitude, latitude);
        if (type.equals("Guardian")){
            return(new Guardian(name, type, coordinates));
        }
        else if (type.equals("Interlect")){
            return(new Interlect(name, type, coordinates));
        }
        else if (type.equals("Super")){
            return(new Super(name, type, coordinates));
        }
        else if (type.equals("Wizard")){
            return(new Wizard(name, type, coordinates));
        }
        else{
            throw new CustomException("[ERROR] Invalid hero type");
        }
    }
}