import java.util.*;

class Solution {
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny, cur[2] + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}