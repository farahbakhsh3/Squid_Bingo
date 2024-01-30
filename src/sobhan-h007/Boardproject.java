package sobhan-h007

  public class Boardproject {

    protected int[][] number;
    protected int[][] mark;

    public Board(int[][] from) {
        this.number = new int[5][5];
        for (int r = 0; r < 5; ++r)
            for (int c = 0; c < 5; ++c)
                this.number[r][c] = from[r][c];
        this.mark = new int[5][5];
      
    }


    protected int sumUnmarked() {
        int sum = 0, r = 0, c = 0;
        for (;r < 5; ++r) {
            for(c = 0;c < 5; ++c) {
                System.err.format(
                    "%c%02d%c ", this.mark[r][c] == 1 ? '[' : ' ',
                  this.number[r][c], this.mark[r][c] == 1 ? ']' : ' ');  
                sum += (1-this.mark[r][c]) * this.number[r][c];

            }
            System.err.print('\n');
        }
        System.err.format("sumOfUnmarked=%d\n", sum);
        return sum;
    }


    public int mark(int numbers) {
        int mark_count, row, col;    
        for (row = 0; row < 5; ++row) {

            mark_count = 0;
            for (col = 0; col < 5; ++col) {
              
                if (this.number[row][col] == numbers)
                    this.mark[row][col] = 1;
                mark_count += this.mark[row][col];
              
            }

            if (mark_count == 5) {
                System.err.format("bingo! for %d in row %d\n", numbers, row);
                return number * this.sumUnmarked();
              
            }
        }

        
        for (col = 0; col < 5; ++col) {
            
            mark_count = 0;
            for (row = 0; row < 5; ++row) {
                if (this.number[row][col] == numbers)
                    this.mark[row][col] = 1;
                mark_count += this.mark[row][col];
              
            }

            if (mark_count == 5) {
                System.err.format("bingo! for %d in column %d\n", numbers, col);
                return numbers * this.sumUnmarked();
            }
        }

        
        return 0;
    }
}
