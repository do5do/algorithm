import java.util.*;

class Solution {
    int[] start = new int[2];
    int[] goal = new int[2];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (board[i].charAt(j) == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        
        return bfs(board);
    }
    
    public int bfs(String[] board) {
        int n = board.length;
        int m = board[0].length();
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
                        if (board[nx].charAt(ny) == 'D') {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny, cur[2] + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}