package za.co.dharriso.swingy.controller;

 public class Coordinates{
    private int longitude;
    private int latitude;
    public Coordinates(int longitude, int latitude){
        this.longitude = longitude;
        this.latitude = latitude; 
        System.out.print(this.longitude + "          " + this.latitude + "\n");
    }
    public int getLongitude(){
        return(this.longitude);
    }
    public int getLatitude(){
        return(this.latitude);
    }
    public void setLongitude(int longitude){
        this.longitude = longitude;
    }
    public void setLatitude(int latitude){
        this.latitude = latitude;
    }
}