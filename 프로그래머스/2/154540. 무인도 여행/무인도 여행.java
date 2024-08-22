import java.util.*;

class Solution {
    int n, m;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[n][m];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    result.add(bfs(i, j, maps));
                }
            }
        }
        
        if (result.isEmpty()) {
            return new int[] {-1};
        }
        
        Collections.sort(result);
        answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public int bfs(int x, int y, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0';
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    char next = maps[nx].charAt(ny);
                    
                    if (!visited[nx][ny] && next != 'X') {
                        sum += next - '0';
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        
        return sum;
    }
}