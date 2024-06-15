import java.util.*;

class Solution {
    int[] goal;
    int[] start;
    int n;
    int m;
    char[][] matrix;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        matrix = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = board[i].charAt(j);
                
                if (matrix[i][j] == 'R') {
                    start = new int[] {i, j};
                } else if (matrix[i][j] == 'G') {
                    goal = new int[] {i, j};
                }
            }
        }
        
        answer = bfs();
        return answer;
    }
    
    public int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 0});
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == goal[0] && cur[1] == goal[1]) {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0];
                int ny = cur[1];
                
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (matrix[nx][ny] == 'D') {
                            break;
                        }
                    } else { 
                        break;
                    }
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, cur[2] + 1});
                }
            }   
        }
        
        return -1;
    }
}