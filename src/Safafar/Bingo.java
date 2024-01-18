package bingo;

public class Bingo {

  private int[][] board;
    private int[][] marks;

    public Bingo(int[][] board) {
        this.board = board;
        this.marks = new int[5][5];
    }

    public void mark(int num) {
        for (int row = 0; row < 5; row++)
            for (int col = 0; col < 5; col++)
                if (this.board[row][col] == num)
                    this.marks[row][col] = 1;
    }

    public boolean is_won() {
        for (int r = 0; r < 5; r++) {
            boolean won = true;
            for (int c = 0; c < 5; c++) {
                if (this.marks[r][c] == 0) {
                    won = false;
                    break;
                }
            }
            if (won)
                return true;
        }

        for (int r = 0; r < 5; r++) {
            boolean won = true;
            for (int c = 0; c < 5; c++) {
                if (this.marks[r][c] == 0) {
                    won = false;
                    break;
                }
            }
            if (won) {
                return true;
            }
        }
    
        return false;
    }

    public int get_score(int called) {
        int score = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                score += this.marks[i][j] * this.board[i][j];
        return score * called;
    }
    
    public static void main(String[] args) {
      
    }    
}
