package squid_bingo;

public class BingoBoard {

    private int[][] data;
    private int[][] marked;

    public BingoBoard(int[][] data) {
        this.data = data;
        this.marked = new int[5][5];
    }

    public void marked(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.data[i][j] == num) {
                    this.marked[i][j] = 1;
                }
            }
        }
    }

    public boolean win() {
        for (int i = 0; i < 5; i++) {
            boolean won = true;
            for (int j = 0; j < 5; j++) {
                if (this.marked[i][j] == 0) {
                    won = false;
                    break;
                }
            }
            if (won) {
                return true;
            }
        }

        for (int j = 0; j < 5; j++) {
            boolean won = true;
            for (int i = 0; i < 5; i++) {
                if (this.marked[i][j] == 0) {
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

    public int score(int called) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.marked[i][j] == 0) {
                    score += this.data[i][j];
                }
            }
        }
        return score * called;
    }

    public void draw() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("--------------");
    }
}
