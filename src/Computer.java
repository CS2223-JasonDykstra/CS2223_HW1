import java.util.HashMap;

public class Computer {

    public Computer(){

    }

    public String makeMove(Board board){
        String move = "";

        int nimSum = this.calculateNimSum(board);
        //if nimsum is 0, make a random move
        //if nimsum != 0, make an optimal move

        //temporary map reference
        HashMap<String, Integer> map = board.getMap();

        //if there is a winning move (with lookahead), make it
        if(this.calculateNimSum(board) != 0){
            for(String key : map.keySet()){
                if((map.get(key) ^ nimSum) < map.get(key)){
                    move += key + " " + (map.get(key) - (map.get(key) ^ nimSum));
                    break;
                }
            }

        //if a winning move is not possible, make a random move
        } else {
            String color = "";
            int randColor = (int)(Math.random() * 3);
            if(randColor == 0){
                color = "green";
            } else if(randColor == 1){
                color = "yellow";
            } else if(randColor == 2){
                color = "red";
            }

            int randNum = (int)(Math.random() * map.get(color) + 1);

            move += color + " " + randNum;
        }

        return move;
    }

    private int calculateNimSum(Board board){
        int nimSum = 0;
        for(String key : board.getMap().keySet()){
            nimSum = nimSum ^ board.getMap().get(key);
        }
        return nimSum;
    }
}
