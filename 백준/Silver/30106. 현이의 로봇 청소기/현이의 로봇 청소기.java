import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        matrix = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j);
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
    }
    
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int diff = Math.abs(matrix[cur[0]][cur[1]] - matrix[nx][ny]);
                    if (!visited[nx][ny] && diff <= k) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}