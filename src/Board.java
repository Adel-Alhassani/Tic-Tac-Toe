
public class Board {

    //Number of board cells
    public static int boardCells = 9;

    public static String[] board = new String[boardCells];

    //initialize the board
    public static void initBoard() {

        //Insert the cells into the game board
        for (int i = 1; i <= boardCells; i++) {
            board[i - 1] = "|" + i + "|";
        }
    }


    public static void printBoard() {
        int count = 0;
        System.out.println();

        //print board content
        for (int i = 0; i < boardCells; i++) {
            if (boardCells > 9) {
                if (Board.board[i].length() > 5) {
                    System.out.print("    " + board[i]);
                } else {
                    System.out.print("    " + board[i]);
                }
            } else {
                System.out.print("    " + board[i]);
            }
            count++;

            //print new line
            if (count == Math.sqrt(boardCells)) {
                System.out.println("\n");
                count = 0;
            }
        }
    }
}
