import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    TicTacToe test = new TicTacToe();

    @Test
    public void firstRowAll_X_ShouldBeWin(){
        Board.initBoard();
        Board.board[0]="X";
        Board.board[1]="X";
        Board.board[2]="X";
        assertTrue(test.checkWin());
    }

    @Test
    public void SecondRowAll_X_ShouldBeWin(){
        Board.initBoard();
        Board.board[3]="X";
        Board.board[4]="X";
        Board.board[5]="X";
        assertTrue(test.checkWin());
    }

    @Test
    public void ThirdRowAll_X_ShouldBeWin(){
        Board.initBoard();
        Board.board[6]="X";
        Board.board[7]="X";
        Board.board[8]="X";
        assertTrue(test.checkWin());
    }

    @Test
    public void firstColumnAll_X_ShouldBeWin(){
        Board.initBoard();
        Board.board[0]="X";
        Board.board[3]="X";
        Board.board[6]="X";
        assertTrue(test.checkWin());
    }

    @Test
    public void secondColumnAll_X_ShouldBeWin(){
        Board.initBoard();
        Board.board[1]="X";
        Board.board[4]="X";
        Board.board[7]="X";
        assertTrue(test.checkWin());
    }

    @Test
    public void thirdColumnAll_X_ShouldBeWin(){
        Board.initBoard();
        Board.board[2]="X";
        Board.board[5]="X";
        Board.board[8]="X";
        assertTrue(test.checkWin());
    }

    @Test
    public void diagonalAll_X_ShouldBeWin(){
        Board.initBoard();
        Board.board[0]="X";
        Board.board[4]="X";
        Board.board[8]="X";
        assertTrue(test.checkWin());
    }

    @Test
    public void reDiagonalAll_X_ShouldBeWin(){
        Board.initBoard();
        Board.board[2]="X";
        Board.board[4]="X";
        Board.board[6]="X";
        assertTrue(test.checkWin());
    }
}