package MMKH;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InnerBingo {
    private int[][] data;
    private int[][] marked;
    public InnerBingo(int[][] data){
        this.data = data;
        this.marked = new int[5][5];
    }     

    public void mark(int num){
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                if (this.data[i][j] == num){
                    this.marked[i][j] = 1;
                }
            }
        }
    }

    public boolean win(){
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

    public int score(int called){
        int score = 0;
        for (int i=0; i<5; i++){        
            for (int j=0; j<5; j++){
                if (this.marked[i][j] == 0){
                    score = score + this.data[i][j];
                }
            }
        }
        return score * called;
    }

    public String toString(){
        
        return Arrays.deepToString(data)
        .replace("], ", "]\n")
        .replace("[", "")
        .replace("]", "");
    }

}



public class Bingo {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        List<Integer> rands = new ArrayList<>();
        List<InnerBingo> boards = new ArrayList<>();
        try{
            BufferedReader file = new BufferedReader(new FileReader("c:/Users/pc/Desktop/Squid_Bingo/src/MMKH/board.txt"));
            for (String line: file.lines().toList()){
                lines.add(line.strip());
            }
            file.close();
            for (String rand: lines.get(0).split(",")){
                rands.add(Integer.parseInt(rand));
            }
            

            for (int i=0; i<100; i++){
                int[][] this_board = new int[5][5];
                for (int j=0; j<5; j++){
                    String this_line = lines.get(i*6+j+2);
                    String[] this_row = this_line.replaceAll(" +", " ").strip().split(" ");
                    int[] new_this_row = new int[5];
                    for (int c=0;c<5; c++){
                        new_this_row[c] = Integer.parseInt(this_row[c]);
                    }
                    this_board[j] = new_this_row;
                }
                boards.add(new InnerBingo(this_board));
            }


            for (int r:rands){
                for (InnerBingo board:boards){
                    board.mark(r);
                    if (board.win()){
                        System.out.println("Winner Board: \n"+board);
                        System.out.println("Score: "+board.score(r));
                        System.exit(1);

                    }
                }
            }

            
            
        }catch (IOException e){
            System.out.println(e);
        }
    }
}