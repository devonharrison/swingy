package hero;

import world.Coordinates;
import utils.CustomException;
import world.Map;

public class Legion{
    public Action newHero(String name, String type, int longitude, int latitude, Map m) throws CustomException{
        Coordinates coordinates = new Coordinates(longitude, latitude);
        //this map is making it funny , check main vs this class
        Map map = new Map(1);
        if (type.equals("guardian")){
            return(new Guardian(name, type, coordinates, m));
        }
        else if (type.equals("interlect")){
            return(new Interlect(name, type, coordinates, m));
        }
        else if (type.equals("superhuman")){
            return(new SuperHuman(name, type, coordinates, m));
        }
        else if (type.equals("wizard")){
            return(new Wizard(name, type, coordinates, m));
        }
        else{
            throw new CustomException("[ERROR] Invalid hero type");
        }
    }
}