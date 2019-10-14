package za.co.dharriso.swingy.hero;

public interface Action{
    public int checkPosition = 0;

    public int updatePostion(String move);
    public void birthOfHero();
    public int checkPosition(String direction);
}