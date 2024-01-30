// package squid_bingo;

class Bingo {
    public int[][] data;
    public int[][] marked;

    public Bingo(int[][] data) {
        this.data = data;
        this.marked = new int[5][5];
    }

    public void mark(int num)
    {
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                if (this.data[i][j] == num){
                    this.marked[i][j] = 1;
                }
            }
        }
    }

    public boolean is_board_win()
    {
        for (int i=0; i<5; i++){
            boolean won = true;
            for (int j=0; j<5; j++){
                if (this.marked[i][j] == 0){
                    won = false;
                }
            }
            if (won){
                return true;
            }
        }
        for (int j=0; j<5; j++ ){
            boolean won = true;
            for (int i=0; i<5; i++){
                if (this.marked[i][j] == 0){
                    won = false;
                }
            }
            if (won){
                return true;
            }
        }
        return false;
    }

    public int score(int called_num)
    {
        return board_score() * called_num;
    }

    public int board_score()
    {
        int score = 0;
        for (int i=0; i<5; i++){        
            for (int j=0; j<5; j++){
                if (this.marked[i][j] == 0){
                    score = score + this.data[i][j];
                }
            }
        }
        return score;
    }
}
