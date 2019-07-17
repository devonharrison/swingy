public class Swingy{
    public static void main(String [] args){
        int argc = args.length;
        if (argc != 1){
            if (argc < 1){
                System.out.println("Please specify tour prefered interface (GUI/console)");
            }
            else{
                System.out.println("Too many options, just one please");
            }
        }
        else{
            String gameType = args[0].toLowerCase();
            if (gameType.equals("console")){
                System.out.println(gameType);
            }
            if (gameType.equals("gui")){
                System.out.println(gameType);
            }
        }
    }
}