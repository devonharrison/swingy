package za.co.dharriso.swingy.utils;

public class CheckHeroState{
    public static int checkPosition;
    public static int view;

    public CheckHeroState(int checkPositionStr, int viewStr){
        checkPosition = checkPositionStr;
        view = viewStr;
    }

    public void setPosition(int checkPositionStr){
        checkPosition = checkPositionStr;
    }

    public void setView(int viewStr){
        view = viewStr;
    }
}