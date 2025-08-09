import java.util.Random;
import java.util.Scanner;

public class Player {

    private char mark;
    private boolean isHuman;
    private String lastMove;
    public String name;

    public Player() {
        mark = 'X';
        isHuman = true;
    }

    public Player(boolean isHuman) {
        this.isHuman = isHuman;
        mark = isHuman ? 'X' : 'O';
    }

    public Player(boolean isHuman, char mark) {
        this.isHuman = isHuman;
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public String getLastMove() {
        return lastMove;
    }

    String promptHumanMove(GameBoard board) {
        Scanner keyboard = new Scanner(System.in);
        String x, y;
        do {
            do {
                System.out.println("Your turn.");
                System.out.println("Enter X value in range [0, " + (board.getSize() - 1) + "]: ");
                x = keyboard.nextLine();
            } while (!isInBounds(x, board));
            do {
                System.out.println("Enter Y value in range [0, " + (board.getSize() - 1) + "]: ");
                y = keyboard.nextLine();
            } while (!isInBounds(y, board));

            lastMove = x + y;
        } while (!board.applyMove(lastMove, mark));

        return lastMove;
    }

    boolean isInBounds(String s, GameBoard board) {
        if (s == null || s.length() != 1) return false;
        char c = s.charAt(0);
        if (c < '0' || c > '9') return false;
        int value = c - '0';
        return value >= 0 && value < board.getSize();
    }

    String generateComputerMove(GameBoard board) {
        String best = AI.findBestMove(board, mark);
        if (!board.applyMove(best, mark)) {
            // Fallback to random valid move
            Random random = new Random();
            do {
                int x = random.nextInt(board.getSize());
                int y = random.nextInt(board.getSize());
                best = Integer.toString(x) + Integer.toString(y);
            } while (!board.applyMove(best, mark));
        }
        lastMove = best;
        return lastMove;
    }
}


