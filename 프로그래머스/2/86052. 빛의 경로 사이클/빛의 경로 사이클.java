import java.util.*;

class Solution {
    int n, m;
    int cnt;
    boolean[][][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public int[] solution(String[] grid) {
        int[] answer = {};
        n = grid.length;
        m = grid[0].length();
        
        // 노드 하나씩 상하좌우로 빛을 쏠 때 사이클을 이루는지 확인
        visited = new boolean[n][m][4];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) { // 0:상, 1:우, 2:하, 3:좌
                    if (!visited[i][j][k]) {
                        cnt = 0;
                        bfs(k, i, j, grid);
                        result.add(cnt);
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
    
    public void bfs(int direction, int x, int y, String[] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y, direction});
        visited[x][y][direction] = true;
        cnt++;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            // 좌표 설정
            int nx = cur[0] + dx[cur[2]];
            int ny = cur[1] + dy[cur[2]];
            
            // 범위를 벗어나면 0 -> n - 1, n - 1 -> 0
            if (nx < 0 || nx > n - 1) {
                nx = n - 1 - cur[0];
            }
            
            if (ny < 0 || ny > m - 1) {
                ny = m - 1 - cur[1];
            }
            
            // 방향 설정 (S는 그대로)
            char next = grid[nx].charAt(ny);
            if (next == 'L') { // 0 -> 1, 1 -> 2, 2 -> 3, 3 -> 0
                direction = (direction + 1) % 4;
            } else if (next == 'R') { // 0 -> 3, 1 -> 0, 2 -> 1, 3 -> 2
                direction = (direction + 3) % 4;
            }
            
            if (!visited[nx][ny][direction]) {
                visited[nx][ny][direction] = true;
                queue.offer(new int[] {nx, ny, direction});
                cnt++;
            }
        }
    }
}