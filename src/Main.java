import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    // Get the input number from the user
    public static int getNum() {
        while (true) {
            try {
                // asking the user to enter 1 or 2
                System.out.print(">>> If you want to play again enter '1' if exit enter '2': ");
                int num = Integer.parseInt(in.nextLine());

                // Check if the user didn't enter a valid number
                if (String.valueOf(num).length() <= 0 || (num != 1 && num != 2)) {
                    System.out.println("*** Invalid input! ***");
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.out.println("*** Invalid input! ***");
            }
        }
    }

    public static void main(String[] args) {
        Operation op = new Operation();
        Board.initBoard();
        Board.printBoard();
        while (true) {
            op.addX();
            if (op.checkWin()) {
                System.out.println("------------ X-Player has won! ------------");
                int id = getNum();
                if (id == 1) {
                    Board.initBoard();
                    Board.printBoard();
                    continue;
                }
                break;
            }
            if (op.checkDraw()) {
                int id = getNum();
                if (id == 1) {
                    Board.initBoard();
                    Board.printBoard();
                    continue;
                }
                break;
            }
            op.addO();
            if (op.checkWin()) {
                System.out.println("------------ O-Player has won! ------------");
                int id = getNum();
                if (id == 1) {
                    Board.initBoard();
                    Board.printBoard();
                    continue;
                }
                break;
            }
            if (op.checkDraw()) {
                int id = getNum();
                if (id == 1) {
                    Board.initBoard();
                    Board.printBoard();
                    continue;
                }
                break;
            }
        }
    }
}
