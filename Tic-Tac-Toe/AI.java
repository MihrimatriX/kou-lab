import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

    private static class Move {
        int x;
        int y;
        Move(int x, int y) { this.x = x; this.y = y; }
    }

    public static String findBestMove(GameBoard board, char aiMark) {
        int size = board.getSize();
        char humanMark = (aiMark == 'X') ? 'O' : 'X';

        char[][] cells = board.getBoard();
        Move best;
        if (size <= 3) best = bestMoveMinimax(cells, size, aiMark, humanMark);
        else best = bestMoveHeuristic(cells, size, aiMark, humanMark);

        if (best == null) {
            // Fallback to first empty
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) if (cells[i][j] == ' ') return Integer.toString(i) + j;
            }
            return "00"; // should not happen
        }
        return Integer.toString(best.x) + best.y;
    }

    private static Move bestMoveHeuristic(char[][] b, int size, char ai, char human) {
        // 1) Win if possible
        Move win = findImmediate(b, size, ai);
        if (win != null) return win;
        // 2) Block opponent's immediate win
        Move block = findImmediate(b, size, human);
        if (block != null) return block;
        // 3) Center if empty
        int center = size / 2;
        if (b[center][center] == ' ') return new Move(center, center);
        // 4) First empty or random among corners/edges
        List<Move> empties = listEmpty(b, size);
        if (empties.isEmpty()) return null;
        // Prefer corners, then edges
        List<Move> corners = new ArrayList<>();
        for (Move m : empties) if ((m.x == 0 || m.x == size - 1) && (m.y == 0 || m.y == size - 1)) corners.add(m);
        if (!corners.isEmpty()) return corners.get(0);
        return empties.get(0);
    }

    private static Move findImmediate(char[][] b, int size, char mark) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (b[i][j] != ' ') continue;
                b[i][j] = mark;
                char w = winnerOf(b, size);
                b[i][j] = ' ';
                if (w == mark) return new Move(i, j);
            }
        }
        return null;
    }

    private static Move bestMoveMinimax(char[][] b, int size, char ai, char human) {
        int bestScore = Integer.MIN_VALUE;
        Move bestMove = null;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (b[i][j] != ' ') continue;
                b[i][j] = ai;
                int score = minimax(b, size, 0, false, ai, human);
                b[i][j] = ' ';
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = new Move(i, j);
                }
            }
        }
        return bestMove;
    }

    private static int minimax(char[][] b, int size, int depth, boolean isMaximizing, char ai, char human) {
        char w = winnerOf(b, size);
        if (w == ai) return 10 - depth;
        if (w == human) return depth - 10;
        if (!hasEmpty(b, size)) return 0;

        if (isMaximizing) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (b[i][j] != ' ') continue;
                    b[i][j] = ai;
                    best = Math.max(best, minimax(b, size, depth + 1, false, ai, human));
                    b[i][j] = ' ';
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (b[i][j] != ' ') continue;
                    b[i][j] = human;
                    best = Math.min(best, minimax(b, size, depth + 1, true, ai, human));
                    b[i][j] = ' ';
                }
            }
            return best;
        }
    }

    private static boolean hasEmpty(char[][] b, int size) {
        for (int i = 0; i < size; i++) for (int j = 0; j < size; j++) if (b[i][j] == ' ') return true;
        return false;
    }

    private static List<Move> listEmpty(char[][] b, int size) {
        List<Move> list = new ArrayList<>();
        for (int i = 0; i < size; i++) for (int j = 0; j < size; j++) if (b[i][j] == ' ') list.add(new Move(i, j));
        return list;
    }

    // Silent winner check; returns 'X', 'O' or ' ' (none)
    private static char winnerOf(char[][] board, int size) {
        int count;
        // Rows and columns
        for (int i = 0; i < size; i++) {
            // Row X / O
            count = 0; for (int j = 0; j < size; j++) if (board[i][j] == 'X') count++; if (count == size) return 'X';
            count = 0; for (int j = 0; j < size; j++) if (board[i][j] == 'O') count++; if (count == size) return 'O';
            // Col X / O
            count = 0; for (int j = 0; j < size; j++) if (board[j][i] == 'X') count++; if (count == size) return 'X';
            count = 0; for (int j = 0; j < size; j++) if (board[j][i] == 'O') count++; if (count == size) return 'O';
        }
        // Diagonals
        boolean d1X = true, d1O = true, d2X = true, d2O = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != 'X') d1X = false;
            if (board[i][i] != 'O') d1O = false;
        }
        for (int i = 0, j = size - 1; i < size; i++, j--) {
            if (board[i][j] != 'X') d2X = false;
            if (board[i][j] != 'O') d2O = false;
        }
        if (d1X || d2X) return 'X';
        if (d1O || d2O) return 'O';
        return ' ';
    }
}


