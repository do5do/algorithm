import java.util.*;

class Solution {
    int[][] matrix = new int[102][102];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int answer = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] r : rectangle) {
            fill(r[0] * 2, r[1] * 2, r[2] * 2, r[3] * 2); // 두배
        }
        
        // 좌표를 두배했으니 동일하게 두배해준다.
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return answer / 2;
    }
    
    public void bfs(int startX, int startY, int goalX, int goalY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY, 0});
        boolean[][] visited = new boolean[102][102];
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == goalX && cur[1] == goalY) {
                answer = cur[2];
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                
                if (nx >= 0 && ny < matrix.length && ny >= 0 && ny < matrix[0].length) {
                    if (!visited[nx][ny] && matrix[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny, cur[2] + 1});
                    }
                }
            }
        }
    }
    
    public void fill(int lx, int ly, int rx, int ry) {
        for (int i = lx; i <= rx; i++) {
            for (int j = ly; j <= ry; j++) {
                if (matrix[i][j] == 2) { // 사각형 내부이면
                    continue;
                }
                
                if (i == lx || i == rx || j == ly || j == ry) {
                    matrix[i][j] = 1; // 테두리 표시
                    continue;
                }
                
                matrix[i][j] = 2; // 나머지는 2
            }
        }
    }
}
