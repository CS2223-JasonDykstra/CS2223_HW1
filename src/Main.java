import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Board board = new Board();
        Computer cpu = new Computer();

        int currentPlayer = 0;
        //1 is first player, 2 is second player.

        //info on double trouble
        System.out.println("Double trouble is a particular instantiation of the game of Nim. Nim (according to wikipedia) was originally “solved” by \nCharles L. Bouton of Harvard University, who also developed the complete theory of the game in 1901. \nToday, there are many instantiations of the game, one of which being “21” played with matchsticks.");


        //Start the game by asking who goes first
        System.out.print("Who goes first? Enter 1 for you, enter 2 for the computer: ");
        currentPlayer = Integer.parseInt(in.nextLine());

        while(currentPlayer != 1 && currentPlayer != 2){
            System.out.print("Please enter either 1 or 2: ");
            currentPlayer = Integer.parseInt(in.nextLine());
        }

        //play the game until it is finished
        while(!board.isGameFinished()) {

            //if it's the cpu's turn
            if (currentPlayer == 2) {
                board.displayBoard();
                String move = cpu.makeMove(board);
                int num = Integer.parseInt(move.substring(move.indexOf(" ") + 1, move.length()));
                String color = move.substring(0, move.indexOf(" "));
                board.updateBoard(color, num);
                System.out.println("The computer took " + num + " tile(s) from " + color + "!");
                currentPlayer = 1;

            //if it's the player's turn
            } else {
                boolean validMove = false;
                board.displayBoard();
                System.out.print("Please enter a color and a number of that color for which you wish to remove (for example: Green 2): ");
                String input;


                String color = "";
                int number = 0;

                //check if input is a valid move
                while(true){
                    input = in.nextLine();
                    if(input.contains(" ")) {
                        color = input.substring(0, input.indexOf(" "));
                        number = Integer.parseInt(input.substring(input.indexOf(" ") + 1, input.length()));
                    }
                    if(board.isValidMove(color, number)){
                        break;
                    } else {
                        System.out.print("Please enter a valid move: ");
                    }
                }

                if (board.isValidMove(color, number)) {
                    board.updateBoard(color, number);
                }
                currentPlayer = 2;
            }
        }

        //when the game is finished
        board.displayBoard();
        System.out.println("Game over.");
        //have to check opposite player ID since you switch currentPlayer after every move, regardless of whether or not you win
        System.out.println((currentPlayer == 2 ? "You win!" : "Computer wins!"));

    }


}
