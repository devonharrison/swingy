package world;

 public class Coordinates{
    private int longitude;
    private int latitude;
    public Coordinates(int longitude, int latitude){
        this.longitude = longitude;
        this.latitude = latitude; 
    }
    public int getLongitude(){
        return(this.longitude);
    }
    public int getLatitude(){
        return(this.latitude);
    }

}