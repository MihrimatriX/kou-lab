import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TicTacToe {

    private int size;
    private boolean shouldContinue;

    public int getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size.equals("3") || size.equals("5") || size.equals("7")) this.size = Integer.parseInt(size);
    }

    public boolean askToContinue(Scanner keyboard) {
        while (true) {
            System.out.println("Do you want to continue? (Y/N)");
            String input = keyboard.nextLine();
            if (input.equalsIgnoreCase("Y")) return true;
            if (input.equalsIgnoreCase("N")) return false;
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
            System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));
        } catch (Exception ignored) {}

        Scanner keyboard = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        do {
            game.size = -1;
            game.shouldContinue = false;

            GameBoard board = null;
            Player human = null;
            Player computer = null;

            String input = null;
            String markInput = null;

            do {
                System.out.println("Do you want to load the game? (Y/N): ");
                input = keyboard.nextLine();

                if (input.equalsIgnoreCase("Y")) {
                    String loaded = GameBoard.load();
                    if (loaded == null || loaded.length() < 1) {
                        System.out.println("No save found. Starting a new game.");
                        while (game.getSize() == -1) {
                            System.out.println("Please enter the board size (3, 5, 7): ");
                            game.setSize(keyboard.nextLine());
                        }
                        board = new GameBoard(game.getSize());
                        System.out.println("Please choose the human player's mark (X/O) (Default X): ");
                        markInput = keyboard.nextLine();
                        char userMark;
                        if (markInput.length() == 1 && markInput.equalsIgnoreCase("X")) userMark = 'X';
                        else if (markInput.length() == 1 && markInput.equalsIgnoreCase("O")) userMark = 'O';
                        else userMark = 'X';
                        char computerMark = (userMark == 'O') ? 'X' : 'O';
                        human = new Player(true, userMark);
                        computer = new Player(false, computerMark);
                    } else {
                        int loadedSize;
                        try {
                            loadedSize = Character.getNumericValue(loaded.charAt(0));
                        } catch (Exception ex) {
                            loadedSize = -1;
                        }
                        if (loadedSize <= 0) {
                            System.out.println("Broken save. Starting a new game.");
                            while (game.getSize() == -1) {
                                System.out.println("Please enter the board size (3, 5, 7): ");
                                game.setSize(keyboard.nextLine());
                            }
                            board = new GameBoard(game.getSize());
                            System.out.println("Please choose the human player's mark (X/O) (Default X): ");
                            markInput = keyboard.nextLine();
                            char userMark;
                            if (markInput.length() == 1 && markInput.equalsIgnoreCase("X")) userMark = 'X';
                            else if (markInput.length() == 1 && markInput.equalsIgnoreCase("O")) userMark = 'O';
                            else userMark = 'X';
                            char computerMark = (userMark == 'O') ? 'X' : 'O';
                            human = new Player(true, userMark);
                            computer = new Player(false, computerMark);
                        } else {
                            board = new GameBoard(loadedSize);
                            for (int i = 0, k = 1; i < loadedSize; i++) {
                                for (int j = 0; j < loadedSize; j++, k++) board.setCell(i, j, loaded.charAt(k));
                            }
                            char c1 = loaded.charAt(loaded.length() - 1);
                            char c2 = (c1 == 'O') ? 'X' : 'O';
                            human = new Player(true, c1);
                            computer = new Player(false, c2);
                        }
                    }
                } else if (input.equalsIgnoreCase("N")) {
                    while (game.getSize() == -1) {
                        System.out.println("Please enter the board size (3, 5, 7): ");
                        game.setSize(keyboard.nextLine());
                    }
                    board = new GameBoard(game.getSize());
                    System.out.println("Please choose the human player's mark (X/O) (Default X): ");
                    markInput = keyboard.nextLine();
                    char userMark;
                    if (markInput.length() == 1 && markInput.equalsIgnoreCase("X")) userMark = 'X';
                    else if (markInput.length() == 1 && markInput.equalsIgnoreCase("O")) userMark = 'O';
                    else userMark = 'X';
                    char computerMark = (userMark == 'O') ? 'X' : 'O';
                    human = new Player(true, userMark);
                    computer = new Player(false, computerMark);
                }
            } while (!(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")));

            board.printBoard();
            while (true) {
                board.save(human.getMark());
                human.promptHumanMove(board);
                System.out.println("Your move: " + human.getLastMove());
                if (board.hasWinner()) break;
                if (!board.hasEmptyCell()) break;
                computer.generateComputerMove(board);
                System.out.println("Computer move: " + computer.getLastMove());
                board.printBoard();
                if (board.hasWinner()) break;
                if (!board.hasEmptyCell()) break;
            }
            board.printBoard();
            game.shouldContinue = game.askToContinue(keyboard);

        } while (game.shouldContinue == true);
    }
}


