import java.util.*;

class Solution {
    int[][] matrix;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n;
    int m;
    int cnt = 0;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();
        matrix = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int item = maps[i].charAt(j);
                if (item == 'X') {
                    matrix[i][j] = -1;
                    continue;
                }
                matrix[i][j] = item - '0';
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && matrix[i][j] != -1) {
                    dfs(i, j);
                    result.add(cnt);
                }
                
                cnt = 0;
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
    
    public void dfs(int x, int y) {
        cnt += matrix[x][y];
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visited[nx][ny] && matrix[nx][ny] != -1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}