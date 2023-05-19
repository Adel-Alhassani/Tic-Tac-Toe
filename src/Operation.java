import java.util.Objects;
import java.util.Scanner;

public class Operation {

    public void addX() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(">>> X-Player turn: ");
            try {
                int i = Integer.parseInt(in.nextLine()) - 1;

                //check if the cell is already chosen
                if (!Board.board[i].contains("|")) {
                    System.out.println("*** this cell has already chosen! ***");
                    continue;
                }

                //replace board's content at 'i' with " X "
                Board.board[i] = " X ";
                Board.printBoard();
                break;
            }

            //check if the user has entered an invalid value
            catch (Exception e) {
                System.out.println("*** Invalid input! ***");
            }
        }
    }

    public void addO() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(">>> O-Player turn: ");
            try {
                int i = Integer.parseInt(in.nextLine()) - 1;

                //check if the cell is already chosen
                if (!Board.board[i].contains("|")) {
                    System.out.println("*** this cell has already chosen! ***");
                    continue;
                }

                //replace board's content at 'i' with " O "
                Board.board[i] = " O ";
                Board.printBoard();
                break;
            }

            // check if the user has entered an invalid value
            catch (Exception e) {
                System.out.println("*** Invalid input! ***");
            }
        }
    }


    //check the draw
    public boolean checkDraw() {

        //check if any cell contain "_"
        for (int i = 0; i < Board.boardCells; i++) {
            if (Board.board[i].contains("|")) {
                return false;
            }
        }
        System.out.println("======= its a draw! =======");
        return true;
    }

    public static final int BOARD_SIZE = (int) Math.sqrt(Board.boardCells);

    private boolean checkSequence(int[] indices) {
        String firstSymbol = Board.board[indices[0]];
        if (firstSymbol.equals(String.valueOf('|'))) {
            return false;
        }
        for (int i = 1; i < indices.length; i++) {
            if (!Objects.equals(Board.board[indices[i]], firstSymbol)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin() {
        // Check rows
        for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i += BOARD_SIZE) {
            int[] rowIndices = new int[BOARD_SIZE];
            for (int j = 0; j < BOARD_SIZE; j++) {
                rowIndices[j] = i + j;
            }
            if (checkSequence(rowIndices)) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            int[] colIndices = new int[BOARD_SIZE];
            for (int j = 0; j < BOARD_SIZE; j++) {
                colIndices[j] = i + j * BOARD_SIZE;
            }
            if (checkSequence(colIndices)) {
                return true;
            }
        }

        // Check diagonal
        int[] diagIndices = new int[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            diagIndices[i] = i * (BOARD_SIZE + 1);
        }
        if (checkSequence(diagIndices)) {
            return true;
        }

        // Check reverse diagonal
        int[] revDiagIndices = new int[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            revDiagIndices[i] = (i + 1) * (BOARD_SIZE - 1);
        }
        if (checkSequence(revDiagIndices)) {
            return true;
        }

        // No winning sequence found
        return false;
    }
}
