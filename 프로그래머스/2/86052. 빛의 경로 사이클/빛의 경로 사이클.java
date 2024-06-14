import java.util.*;

class Solution {
    int n;
    int m;
    boolean[][][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] grid) {
        int[] answer = {};
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m][4];
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) { // 0:상, 1:우, 2:하, 3:좌
                    if (!visited[i][j][k]) {
                        result.add(bfs(i, j, k, grid));
                    }
                }
            }
        }
        
        Collections.sort(result);
        answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public int bfs(int x, int y, int direct, String[] grid) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y, direct});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (visited[cur[0]][cur[1]][cur[2]]) {
                continue;
            }
            visited[cur[0]][cur[1]][cur[2]] = true;
            
            // 좌표 설정
            int nx = cur[0] + dx[cur[2]];
            int ny = cur[1] + dy[cur[2]];
            
            // 0 -> n - 1, n - 1 -> 0
            if (nx < 0 || nx > n - 1) {
                nx = Math.abs(n - 1 - cur[0]);
            }
            
            if (ny < 0 || ny > m - 1) {
                ny = Math.abs(m - 1 - cur[1]);
            }
            
            // 방향 설정
            char next = grid[nx].charAt(ny);
            int nd = cur[2];
            
            if (next == 'L') { // 0 -> 3, 1 -> 0, 2 -> 1, 3 -> 2
                nd = (nd + 3) % 4;
            } else if (next == 'R') { // 0 -> 1, 1 -> 2, 2 -> 3, 3 -> 0
                nd = (nd + 1) % 4;
            }
            
            queue.offer(new int[] {nx, ny, nd});
            result++;
        }
        
        return result;
    }
}