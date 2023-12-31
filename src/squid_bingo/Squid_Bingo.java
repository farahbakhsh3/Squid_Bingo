package squid_bingo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Squid_Bingo {

    private static ArrayList<String> readFile(String fileName) {
        String line;
        ArrayList<String> lines = new ArrayList<>();

        try {
            FileReader fr = new FileReader(fileName);
            try (BufferedReader br = new BufferedReader(fr)) {
                while ((line = br.readLine()) != null) {
                    if (line.trim().length() > 0) {
                        lines.add(line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return lines;
    }

    private static ArrayList<Integer> readNums(String[] stringNums) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (String num : stringNums) {
            nums.add(Integer.valueOf(num.trim()));
        }
        return nums;
    }

    public static void main(String[] args) {
        BingoBoard[] boards = new BingoBoard[100];

        ArrayList<String> lines = readFile(".\\data.txt");

        ArrayList<Integer> randNums = readNums(lines.get(0).split(","));
        for (int num : randNums) {
            System.out.print(num + ", ");
        }
        System.out.println("\n------------------\n");

        String line;
        for (int idxLine = 1; idxLine < lines.size(); idxLine += 5) {
            int[][] board = new int[5][5];
            for (int bLine = 0; bLine < 5; bLine++) {
                line = lines.get(idxLine + bLine);
                int bLineCol = 0;
                for (String n : line.split(" ")) {
                    if (n.trim().length() > 0) {
                        board[bLine][bLineCol] = Integer.parseInt(n);
                        bLineCol++;
                    }
                }
            }
            boards[idxLine / 5] = new BingoBoard(board);
        }

        System.out.println("\n----------------------\n");

        boolean win = false;
        for (int randNum : randNums) {
            for (BingoBoard board : boards) {
                board.marked(randNum);
                if (board.win()) {
                    System.out.println("Score is :: " + board.score(randNum));
                    board.draw();
                    win = true;
                    break;
                }
            }
            if (win) {
                break;
            }
        }
    }
}
