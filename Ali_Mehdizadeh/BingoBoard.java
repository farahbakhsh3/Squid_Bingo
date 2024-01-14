package squid_bingo;

public class BingoBoard {

    private static final int BOARD_SIZE = 5;
    private int[][] data;
    private int[][] marked;

    public BingoBoard(int[][] data) {
        this.data = data;
        this.marked = new int[BOARD_SIZE][BOARD_SIZE];
    }

    public void mark(int num) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (this.data[i][j] == num) {
                    this.marked[i][j] = 1;
                }
            }
        }
    }

    public boolean win() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            boolean rowWon = true;
            boolean colWon = true;

            for (int j = 0; j < BOARD_SIZE; j++) {
                if (marked[i][j] == 0) {
                    rowWon = false;
                }

                if (marked[j][i] == 0) {
                    colWon = false;
                }
            }

            if (rowWon || colWon) {
                return true;
            }
        }

        return false;
    }

    public int score(int called) {
        int score = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (marked[i][j] == 0) {
                    score += data[i][j];
                }
            }
        }
        return score * called;
    }

    public void draw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("--------------");
    }

    public boolean isMarked(int row, int col) {
        return marked[row][col] == 1;
    }

    public int[][] getData() {
        return data;
    }

    public int[][] getMarked() {
        return marked;
    }
}
