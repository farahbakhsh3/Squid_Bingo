package D0x45;

public class Board {
    //       c = 0 1 2 3 4
    //           ^ ^ ^ ^ ^
    // [         | | | | |
    //   r=0 -> [0,0,0,0,0],
    //   r=1 -> [0,0,0,0,0],
    //   r=2 -> [0,0,0,0,0],
    //   r=3 -> [0,0,0,0,0],
    //   r=4 -> [0,0,0,0,0]
    // ]
    protected int[][] numbers;
    protected int[][] marks;

    public Board(int[][] from) {
        this.numbers = new int[5][5];
        // copy number values row by row 
        for (int r = 0; r < 5; ++r)
            for (int c = 0; c < 5; ++c)
                this.numbers[r][c] = from[r][c];
        // 1 means marked, 0 means not marked
        this.marks = new int[5][5];
    }

    // sum of unmarked numbers
    protected int sumUnmarked() {
        int sum = 0, r = 0, c = 0;
        for (;r < 5; ++r) {
            for(c = 0;c < 5; ++c) {
                System.err.format(
                    "%c%02d%c ",
                    this.marks[r][c] == 1 ? '[' : ' ',
                    this.numbers[r][c],
                    this.marks[r][c] == 1 ? ']' : ' '
                );
                sum += (1-this.marks[r][c]) * this.numbers[r][c];
                //     ^^^^^^^^^^^^^^^^^^^^^^^ marked numbers are 1, and unmarked 0
                // therefore, (1-1 = 0) and (1-0=1), so marked numbers contribute nothing to the sum
                // on the other hand unmarked numbers are summed up
            }
            System.err.print('\n');
        }
        System.err.format("sumOfUnmarked=%d\n", sum);
        return sum;
    }

    // 5 consecutive numbers is a win
    // either vertical, horizontal
    // returns score if bingo, otherwise 0
    public int mark(int number) {
        int mark_count, row, col;

        // iterate row-first (-->)
        for (row = 0; row < 5; ++row) {
            // reset before each row
            mark_count = 0;
            for (col = 0; col < 5; ++col) {
                // mark the number
                if (this.numbers[row][col] == number)
                    this.marks[row][col] = 1;
                // increment counter
                mark_count += this.marks[row][col];
            }
            // check if all 5 columns in this row were marked
            // multiply that sum by the number that was just called when the board won
            if (mark_count == 5) {
                System.err.format("bingo! for %d in row %d\n", number, row);
                return number * this.sumUnmarked();
            }
        }

        // iterate column-first v
        for (col = 0; col < 5; ++col) {
            // reset before each column
            mark_count = 0;
            for (row = 0; row < 5; ++row) {
                // mark the number
                if (this.numbers[row][col] == number)
                    this.marks[row][col] = 1;
                // increment counter
                mark_count += this.marks[row][col];
            }
            // check if all 5 rows in this column were marked
            // multiply that sum by the number that was just called when the board won
            if (mark_count == 5) {
                System.err.format("bingo! for %d in column %d\n", number, col);
                return number * this.sumUnmarked();
            }
        }

        // not bingo!
        return 0;
    }
}
