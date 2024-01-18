package D0x45;

import java.util.Scanner;
import java.util.Vector;

public class BingoGame {
    protected static Vector<Integer> readNumberLine(Scanner scanner, char separator) {
        String[] items = scanner.nextLine().trim().split(Character.toString(separator));
        Vector<Integer> numbers = new Vector<>();
        for (String number : items) {
            number = number.trim(); // TODO: improve
            if (number.length() == 0) continue;
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> announcedNumbers = readNumberLine(scanner, ',');
        Vector<BingoBoard> bingoBoards = new Vector<>();
        
        do {
            scanner.nextLine(); // skip empty line
            int[][] currentBoardNumbers = new int[5][5];
            for (int row = 0; row < 5; ++row) {
                Vector<Integer> rowNumbers = readNumberLine(scanner, ' ');
                for (int col = 0; col < 5; ++col) {
                    currentBoardNumbers[row][col] = rowNumbers.get(col);
                }
            }
            bingoBoards.add(new BingoBoard(currentBoardNumbers));
        } while(scanner.hasNextLine());

        scanner.close();

        for (final int announcedNumber : announcedNumbers) {
            for (int i = 0; i < bingoBoards.size(); ++i) {
                int score = bingoBoards.get(i).mark(announcedNumber);
                if (score != 0) {
                    System.out.format("Board #%d has the first bingo with score %d!\n", i+1, score);
                    return;
                }
            }
        }

        System.out.println("No Winning Board!!!");
    }
}
