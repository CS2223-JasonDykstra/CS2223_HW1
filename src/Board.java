import java.util.HashMap;

public class Board {
    private HashMap<String, Integer> tiles = new HashMap<>();


    public Board(){
        tiles.put("green", 3);
        tiles.put("yellow", 7);
        tiles.put("red", 5);
    }

    public void displayBoard(){
        System.out.println("------------Board------------");
        System.out.print("Green Tiles (" + tiles.get("green") + "):");
        for(int i = 0; i < tiles.get("green"); i++){
            System.out.print(" G");
        }
        System.out.println();

        System.out.print("Yellow Tiles (" + tiles.get("yellow") + "):");
        for(int i = 0; i < tiles.get("yellow"); i++){
            System.out.print(" Y");
        }
        System.out.println();

        System.out.print("Red Tiles (" + tiles.get("red") + "):");
        for(int i = 0; i < tiles.get("red"); i++){
            System.out.print(" R");
        }
        System.out.println();
        System.out.println("-----------------------------");
    }

    public boolean isValidMove(String color, int number){
        if(tiles.get(color) == null || tiles.get(color) < number || number <= 0){
            return false;
        }
        return true;
    }

    public void updateBoard(String color, int number){
        tiles.replace(color, tiles.get(color) - number);
    }

    //check if the game is finished or not
    public boolean isGameFinished(){
        int tilesLeft = tiles.get("green") + tiles.get("yellow") + tiles.get("red");
        return tilesLeft == 0;
    }

    public HashMap<String, Integer> getMap(){
        return tiles;
    }
}
