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

    private static void draw(int[][] board) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("--------------");
    }

    public static void main(String[] args) {
        ArrayList<String> lines = readFile(".\\data.txt");

        ArrayList<Integer> nums = readNums(lines.get(0).split(","));
        for (int num : nums) {
            System.out.print(num+", ");
        }

        int[][] board = new int[5][5];
        String line;
        for (int idxLine = 1; idxLine < lines.size(); idxLine += 5) {
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
            draw(board);
        }
    }
}
