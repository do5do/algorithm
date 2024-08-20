import java.util.*;

class Solution {
    int[] start = new int[2];
    int[] lever = new int[2];
    int[] exit = new int[2];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (maps[i].charAt(j) == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        
        int leverCnt = bfs(maps, start, lever);
        if (leverCnt == -1) {
            return -1;
        }
        
        int exitCnt = bfs(maps, lever, exit);
        if (exitCnt == -1) {
            return -1;
        }
        
        return leverCnt + exitCnt;
    }
    
    public int bfs(String[] maps, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 0});
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == end[0] && cur[1] == end[1]) {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny, cur[2] + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}