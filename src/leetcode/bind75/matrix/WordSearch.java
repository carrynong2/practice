package leetcode.bind75.matrix;

public class WordSearch {
    static void main() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if (dfs(board, word, 1, i, j, visited, dx, dy)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i,
                               int i1, int j, boolean[][] visited, int[] dx, int[] dy) {
        if (i == word.length()) {
            return true;
        }
        for (int k = 0; k < 4; k++) {
            int x = i1 + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                    && !visited[x][y] && board[x][y] == word.charAt(i)) {
                visited[x][y] = true;
                if (dfs(board, word, i + 1, x, y, visited, dx, dy)) {
                    return true;
                }
                visited[x][y] = false;
            }
        }
        return false;
    }

}
