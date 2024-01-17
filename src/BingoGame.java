package BingoGame;

import java.util.Scanner;
import java.util.Vector;

public class BingoGame {
    protected static Vector<Integer> readNumberLine(Scanner scanner, char separator) {
        String[] items = scanner.nextLine().trim().split(Character.toString(separator));
        Vector<Integer> numbers = new Vector<>();
        for (String num : items) {
            num = num.trim(); // TODO: improve
            if (num.length() == 0) continue;
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> announcedNumbers = readNumberLine(scanner, ',');
        Vector<BingoBoard> boards = new Vector<>();

        do {
            scanner.nextLine(); // skip empty line
            int[][] tmp = new int[5][5];
            for (int row = 0; row < 5; ++row) {
                Vector<Integer> rowNumbers = readNumberLine(scanner, ' ');
                for (int col = 0; col < 5; ++col) {
                    tmp[row][col] = rowNumbers.get(col);
                }
            }
            boards.add(new BingoBoard(tmp));
        } while(scanner.hasNextLine());

        scanner.close();

        for (final int num : announcedNumbers) {
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
