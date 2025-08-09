import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GameBoard {

    private int size;
    private char[][] board;

    public GameBoard() {
        setSize(3);
        board = new char[getSize()][getSize()];
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                board[i][j] = ' ';
            }
        }
    }

    public GameBoard(int size) {
        this.setSize(size);
        board = new char[size][size];
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                board[i][j] = ' ';
            }
        }
    }

    public GameBoard(char[][] board) {
        this.board = board;
    }

    public void setCell(int i, int j, char c) {
        board[i][j] = c;
    }

    public void printBoard() {
        int i, j;
        char letter = 'A';

        for (i = 0; i < getSize(); i++, letter++) System.out.print(" |" + letter);
        System.out.println();

        for (i = 0; i < getSize(); i++) {
            for (j = 0; j < getSize(); j++) System.out.print("---");
            System.out.println();
            System.out.print(i);
            for (j = 0; j < getSize(); j++) System.out.print("|" + board[i][j] + " ");
            System.out.println();
        }
    }

    char[][] getBoard() {
        return board;
    }

    boolean applyMove(String coordinate, char playerMark) {
        int x = Integer.parseInt(coordinate.substring(0, 1));
        int y = Integer.parseInt(coordinate.substring(1, 2));

        if (board[x][y] != ' ') return false;

        board[x][y] = playerMark;
        return true;
    }

    boolean hasWinner() {
        boolean d1 = true, d2 = true, d3 = true, d4 = true;
        int rowX = 0, colX = 0, rowO = 0, colO = 0;

        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (board[i][j] == 'X') rowX++;
                if (board[j][i] == 'X') colX++;
                if (board[i][j] == 'O') rowO++;
                if (board[j][i] == 'O') colO++;
            }
            if (rowX == getSize() || colX == getSize()) {
                System.out.println("Player X wins");
                return true;
            }
            if (rowO == getSize() || colO == getSize()) {
                System.out.println("Player O wins");
                return true;
            }
            rowX = 0; colX = 0; rowO = 0; colO = 0;
        }

        for (int i = 0; i < getSize(); i++) {
            if (board[i][i] != 'X') d1 = false;
            if (board[i][i] != 'O') d3 = false;
        }
        for (int i = 0, j = getSize() - 1; i < getSize(); i++, j--) {
            if (board[i][j] != 'X') d2 = false;
            if (board[i][j] != 'O') d4 = false;
        }

        if (d1 || d2) {
            System.out.println("Player X wins");
            return true;
        }
        if (d3 || d4) {
            System.out.println("Player O wins");
            return true;
        }

        return false;
    }

    boolean hasEmptyCell() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (board[i][j] == ' ') return true;
            }
        }
        System.out.println("Draw");
        return false;
    }

    void save(char mark) throws IOException {
        try (FileOutputStream out = new FileOutputStream("game-save.txt")) {
            out.write((char) (getSize() + '0'));
            for (int i = 0; i < getSize(); i++)
                for (int j = 0; j < getSize(); j++)
                    out.write(board[i][j]);
            out.write(mark);
        } catch (Exception e) {
            System.out.println("Error: could not write save file");
        }
    }

    static String load() throws IOException {
        String content = null;
        try (FileInputStream in = new FileInputStream("game-save.txt")) {
            content = (char) in.read() + "";
            int size = Integer.parseInt(content);
            for (int i = 0; i < size * size + 1; i++) content = content + (char) in.read();
        } catch (Exception e) {
            System.out.println("Error: save file not found");
        }
        return content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


