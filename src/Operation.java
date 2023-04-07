import java.util.Scanner;

public class Operation {

    public void addX() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(">>> X-Player turn: ");
            try {
                int i = Integer.parseInt(in.nextLine())-1;
                if (!Board.board[i].contains("_")) {
                    System.out.println("*** this cell has already chosen! ***");
                    continue;
                }
                Board.board[i] = "  X  ";
                break;
            } catch (Exception e) {
                System.out.println("*** Invalid! ***");
            }
        }
    }

    public void addO() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(">>> O-Player turn: ");
            try {
                int i = Integer.parseInt(in.nextLine())-1;
                if (!Board.board[i].contains("_")) {
                    System.out.println("*** this cell has already chosen! ***");
                    continue;
                }
                Board.board[i] = "  O  ";
                break;
            } catch (Exception e) {
                System.out.println("*** Invalid! ***");
            }
        }
    }

    public boolean checkDraw() {
        for (int i = 0; i < Board.boardCells; i++) {
            if (Board.board[i].contains("_")) {
                return false;
            }
        }
        System.out.println("======= its draw! =======");
        return true;
    }

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

        // diagonal
        for (int i = 0; i < boardSize; i++) {
            if (Board.board[diag].contains("_")) {
                checkDiag = false;
                break;
            }
            if (!Board.board[0].equals(Board.board[diag])) {
                checkDiag = false;
            }
            diag = diag + boardSize+1;

        }
        if (checkDiag) {
            return true;
        }

        //re_diagonal
        for (int i = 0; i < boardSize; i++) {
            if (Board.board[re_diag].contains("_")) {
                checkRe_diag = false;
                break;
            }
            if (!Board.board[boardSize - 1].equals(Board.board[re_diag])) {
                checkRe_diag = false;
            }
            re_diag = re_diag + (boardSize - 1);
        }
        if (checkRe_diag) {
            return true;
        }


        // row
        for (int i = 0; i < Board.boardCells; i++) {
            if ((i % boardSize != 0)) {
                continue;
            }
            checkRow = true;
            row = i;
            for (int j = 0; j < boardSize - 1; j++) {
                row = row + 1;
                if (Board.board[row].contains("_")) {
                    checkRow = false;
                    break;
                }
                if (!Board.board[i].equals(Board.board[row])) {
                    checkRow = false;
                    break;
                }
            }
            if (checkRow) {
                return true;
            }
        }

        // col
        for (int i = 0; i < boardSize; i++) {
            if (Board.board[i].contains("_")) {
                continue;
            }
            checkCol = true;
            col = i;
            for (int j = 0; j < boardSize - 1; j++) {
                col = col + boardSize;
                if (Board.board[col].contains("_")) {
                    checkCol = false;
                    break;
                }
                if (!Board.board[i].equals(Board.board[col])) {
                    checkCol = false;
                    break;
                }
            }
            if (checkCol) {
                return true;
            }
        }
        return false;
    }
}
