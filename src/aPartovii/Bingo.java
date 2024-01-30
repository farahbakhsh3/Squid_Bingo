package aPartovii;

class Bingo {
    public int[][] board;
    public int[][] marked;

    public Bingo(int[][] board) {
        this.board = board;
        this.marked = new int[5][5];
    }

    public int score()
    {
        int score = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (this.marked[row][col] == 1) {
                    score += this.board[row][col];
                }
            }
        }
        return score;
    }

    public boolean mark_number_on_board(int number) {
        for (int row = 0; row < 5; ++row) {
            boolean win = true;

            for (int col = 0; col < 5; ++col) {
                if (this.marked[row][col] == 0) {
                    win = false;
                }
            }

            if (win) {
                return true;
            }
        }

        for (int col = 0; col < 5; ++col) {

            boolean win = true;

            for (int row = 0; row < 5; ++row) {
                if (this.marked[row][col] == 0) {
                    win = false;
                }
            }

            if (win)
                return true;
        }

        return false;
    }
}
