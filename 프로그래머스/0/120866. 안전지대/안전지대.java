class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        boolean[][] visited = new boolean[n][n];
        int danger = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    danger++;
                    visited[i][j] = true;
                    
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }
                        
                        if (visited[nx][ny] || board[nx][ny] == 1) {
                            continue;
                        }
                        
                        board[nx][ny] = 1;
                        visited[nx][ny] = true;
                        danger++;
                    }
                }
            }
        }

        return (n * n) - danger;
    }
}