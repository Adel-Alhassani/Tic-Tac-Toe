
public class Main {
    public static void main(String[] args) {
        Operation op = new Operation();

        Board.startBoard();
        Board.showBoard();

        while (true) {
            op.addX();
            Board.showBoard();
            if (op.checkDraw()) {
                break;
            }
            if (op.checkWin()) {
                System.out.println("------------ X-Player has won! ------------");
                break;
            }
            op.addO();
            Board.showBoard();
            if (op.checkDraw()) {
                break;
            }
            if (op.checkWin()) {
                System.out.println("------------ O-Player has won! ------------");
                break;
            }
        }
    }
}
