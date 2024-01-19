import java.util.ArrayList;
import java.util.Collections;

public class BingoGame {
    private ArrayList<Integer> numbers; // لیستی برای نگهداری اعداد بینگو
    private static final int SIZE = 5; // اندازه جدول بینگو

    public BingoGame() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); // تصادفی کردن ترتیب اعداد
    }

    public int[] draw() {
        int[] result = new int[SIZE * SIZE];
        for (int i = 0; i < SIZE * SIZE; i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        BingoGame game = new BingoGame();
        int[] board = game.draw();

        for (int i = 0; i < SIZE * SIZE; i++) {
            System.out.print(board[i] + "\t");
            if ((i + 1) % SIZE == 0) {
                System.out.println();
            }
        }
    }
}import java.util.ArrayList;
import java.util.Collections;

public class BingoGame {
    private ArrayList<Integer> numbers; // لیستی برای نگهداری اعداد بینگو
    private static final int SIZE = 5; // اندازه جدول بینگو

    public BingoGame() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); // تصادفی کردن ترتیب اعداد
    }

    public int[] draw() {
        int[] result = new int[SIZE * SIZE];
        for (int i = 0; i < SIZE * SIZE; i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        BingoGame game = new BingoGame();
        int[] board = game.draw();

        for (int i = 0; i < SIZE * SIZE; i++) {
            System.out.print(board[i] + "\t");
            if ((i + 1) % SIZE == 0) {
                System.out.println();
            }
        }
    }
}
