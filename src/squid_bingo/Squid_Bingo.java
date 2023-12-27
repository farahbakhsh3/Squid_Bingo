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
        Bingo[] boards = new Bingo[100];
        
        ArrayList<String> lines = readFile(".\\data.txt");

        ArrayList<Integer> randNums = readNums(lines.get(0).split(","));
        for (int num : randNums) {
            System.out.print(num+", ");
        }
        System.out.println("\n------------------\n");

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
            boards[idxLine/5] = new Bingo(board);
        }
        
        System.out.println("\n----------------------\n");
        
        boolean win = false;
        for(int randNum : randNums){
            for(int i=0; i < boards.length; i++){
                boards[i].marked(randNum);
                if (boards[i].win()){
                    System.out.println("Score is :: " + boards[i].score(randNum));
                    boards[i].draw();
                    win = true;
                    break;
                }
            }
            if (win){
                break;
            }
        }
    }
}
