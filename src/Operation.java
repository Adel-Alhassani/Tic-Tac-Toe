import java.util.Scanner;

public class Operation {

    public void addX() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(">>> X-Player turn: ");
            try {
                int i = Integer.parseInt(in.nextLine()) - 1;

                //check if the cell is already chosen
                if (!Board.board[i].contains("_")) {
                    System.out.println("*** this cell has already chosen! ***");
                    continue;
                }

                //replace board's content at 'i' with " X "
                Board.board[i] = "  X  ";
                break;
            }

            //check if the user has entered an invalid value
            catch (Exception e) {
                System.out.println("*** Invalid! ***");
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
                if (!Board.board[i].contains("_")) {
                    System.out.println("*** this cell has already chosen! ***");
                    continue;
                }

                //replace board's content at 'i' with " O "
                Board.board[i] = "  O  ";
                break;
            }

            // check if the user has entered an invalid value
            catch (Exception e) {
                System.out.println("*** Invalid! ***");
            }
        }
    }


    //check the draw
    public boolean checkDraw() {

        //check if any cell contain "_"
        for (int i = 0; i < Board.boardCells; i++) {
            if (Board.board[i].contains("_")) {
                return false;
            }
        }
        System.out.println("======= its draw! =======");
        return true;
    }

    //check if there is a winner
    public boolean checkWin() {
        int boardSize = (int) Math.sqrt(Board.boardCells);
        int row;
        boolean checkRow;
        int col;
        boolean checkCol;
        int diag = 0;
        boolean checkDiag = true;
        int re_diag = boardSize - 1;
        boolean checkRe_diag = true;

        //check diagonal
        for (int i = 0; i < boardSize; i++) {

            //check if the diagonal contain "_"
            if (Board.board[diag].contains("_")) {
                checkDiag = false;
                break;
            }

            //check if the diagonal's cells is not equal each other
            if (!Board.board[0].equals(Board.board[diag])) {
                checkDiag = false;
            }

            //diag=the next diagonal's cell
            diag = diag + boardSize + 1;

        }
        if (checkDiag) {
            return true;
        }

        //check re_diagonal
        for (int i = 0; i < boardSize; i++) {
            if (Board.board[re_diag].contains("_")) {
                checkRe_diag = false;
                break;
            }

            //check if the re_diagonal's cells is not equal each other
            if (!Board.board[boardSize - 1].equals(Board.board[re_diag])) {
                checkRe_diag = false;
            }

            //re_diag=the next re_diagonal's cell
            re_diag = re_diag + (boardSize - 1);
        }
        if (checkRe_diag) {
            return true;
        }


        //check row
        for (int i = 0; i < Board.boardCells; i++) {

            //check if 'i' is first row's number (from left)
            // if it's not then skip
            if ((i % boardSize != 0)) {
                continue;
            }
            checkRow = true;

            //row = the first number at the row (from left)
            row = i;
            for (int j = 0; j < boardSize - 1; j++) {
                row = row + 1;

                //check if the row contain "_"
                if (Board.board[row].contains("_")) {
                    checkRow = false;
                    break;
                }

                //check if the row's cells is not equal each other
                if (!Board.board[i].equals(Board.board[row])) {
                    checkRow = false;
                    break;
                }
            }
            if (checkRow) {
                return true;
            }
        }

        //check column
        for (int i = 0; i < boardSize; i++) {

            //check if the row contain "_"
            if (Board.board[i].contains("_")) {
                continue;
            }
            checkCol = true;

            //col = the first number at the column
            col = i;
            for (int j = 0; j < boardSize - 1; j++) {

                //col=the next column's cell
                col = col + boardSize;

                //check if the column contain "_"
                if (Board.board[col].contains("_")) {
                    checkCol = false;
                    break;
                }

                //check if the column's cells is not equal each other
                if (!Board.board[i].equals(Board.board[col])) {
                    checkCol = false;
                    break;
                }
            }
            if (checkCol) {
                return true;
            }
        }
        //if there is no winner
        return false;
    }
}
