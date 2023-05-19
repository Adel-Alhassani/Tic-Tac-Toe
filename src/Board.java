
public class Board {

    //Number of board cells (9:3x3, 16:4x4,...)
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
        System.out.print("    ");

        // Iterate over each cell in the board
        for (int i = 0; i < boardCells; i++) {

            // If we've printed a full row, start a new line and reset the count
            if (count == Math.sqrt(boardCells)) {
                System.out.println("\n");
                System.out.print("    ");
                count = 0;
            }

            // Determine how much padding to add to the cell value, based on the board size
            if (boardCells > 9) {

                // Check if the cell value > 9, based on its length
                if (Board.board[i].length() > 3) {
                    System.out.print(board[i] + "   ");
                } else {
                    System.out.print(board[i] + "    ");
                }
            } else {
                System.out.print(board[i] + "    ");
            }
            count++;
        }
        System.out.println("\n");
    }
}
