package D0x45;

import java.util.Scanner;
import java.util.Vector;

public class Bingo {
    protected static Vector<Integer> readNumberLine(Scanner scan, char sep) {
        String[] items = scan.nextLine().trim().split(Character.toString(sep));
        Vector<Integer> numbers = new Vector<>();
        for (String num : items) {
            num = num.trim(); // TODO: improve
            if (num.length() == 0) continue;
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Vector<Integer> announced_numbers = readNumberLine(scan, ',');
        Vector<Board> boards = new Vector<>();
        
        do {
            scan.nextLine(); // skip empty line
            int[][] tmp = new int[5][5];
            for (int row = 0; row < 5; ++row) {
                Vector<Integer> r_num = readNumberLine(scan, ' ');
                for (int col = 0; col < 5; ++col) {
                    tmp[row][col] = r_num.get(col);
                }
            }
            boards.add(new Board(tmp));
        } while(scan.hasNextLine());

        scan.close();

        for (final int num : announced_numbers) {
            for (int i = 0; i < boards.size(); ++i) {
                int score = boards.get(i).mark(num);
                if (score != 0) {
                    System.out.format("Board #%d has the first bingo with score %d!\n", i+1, score);
                    return;
                }
            }
        }

        System.out.println("No Winning Board!!!");
    }
}
