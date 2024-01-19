
class BingoCard {

    private int[][] numbers;

    private boolean[][] marked;

    private int player;

    private boolean win;

    public BingoCard(int player) {

        numbers = new int[5][5];
        marked = new boolean[5][5];
        this.player = player;
        this.win = false;

        int[] used = new int[76];

        Random random = new Random();

        for (int col = 0; col < 5; col++) {

            int lower = col * 15 + 1;
            int upper = lower + 14;

            for (int row = 0; row < 5; row++) {

                if (row == 2 && col == 2) {
                    numbers[row][col] = 0;
                    marked[row][col] = true;
                } else {

                    int num = random.nextInt(upper - lower + 1) + lower;

                    while (used[num] == 1) {
                        num = random.nextInt(upper - lower + 1) + lower;
                    }

                    numbers[row][col] = num;
                    used[num] = 1;
                    marked[row][col] = false;
                }
            }
        }
    }

    public void printCard() {
        System.out.printf("Player %d\n", this.player);
        System.out.println("_____________________");
        for (int i = 0; i < 5; i++) {
            System.out.println("|---|---|---|---|---|");
            for (int j = 0; j < 5; j++)
                if (marked[i][j] == true)
                    System.out.printf("|%3s", "X");
                else
                    System.out.printf("|%3d", numbers[i][j]);
            System.out.println("|");
        }
        System.out.println("|---|---|---|---|---|");
        System.out.println("_____________________\n\n");
    }

    public void markNumber(int number) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (numbers[i][j] == number)
                    marked[i][j] = true;
    }

    public boolean checkWin() {

        int rowCount, colCount, diagCount1, diagCount2;
        diagCount1 = diagCount2 = 0;
        for (int i = 0; i < 5; i++) {
            rowCount = colCount = 0;
            for (int j = 0; j < 5; j++) {
                if (marked[i][j])
                    rowCount++;
                if (marked[j][i])
                    colCount++;
            }

            if (rowCount == 5 || colCount == 5) {
                this.win = true;
                return true;
            }

            if (marked[i][i])
                diagCount1++;
            if (marked[i][4 - i])
                diagCount2++;
        }

        if (diagCount1 == 5 || diagCount2 == 5) {
            this.win = true;
            return true;
        }

        this.win = false;
        return false;
    }

    public int getPlayer() {
        return this.player;
    }

    public boolean isWin() {
        return this.win;
    }
}

//