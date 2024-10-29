import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, h;
    static int[][][] matrix;
    static boolean[][][] visited;
    static int zeroCnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dh = {-1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        matrix = new int[n][m][h];
        visited = new boolean[n][m][h];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    matrix[i][j][k] = Integer.parseInt(st.nextToken());

                    if (matrix[i][j][k] == 0) {
                        zeroCnt++;
                    } else if (matrix[i][j][k] == 1) {
                        queue.offer(new int[] {i, j, k, 0});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        if (zeroCnt == 0) {
            System.out.println(0);
            return;
        }

        bfs();
        if (zeroCnt > 0) {
            System.out.println(-1);
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int day = cur[3];

            for (int i = 0; i < 4; i++) { // 상하좌우
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nh = cur[2];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny][nh] && matrix[nx][ny][nh] == 0) {
                    visited[nx][ny][nh] = true;
                    zeroCnt--;
                    if (zeroCnt == 0) {
                        System.out.println(day + 1);
                        return;
                    }
                    queue.offer(new int[] {nx, ny, nh, day + 1});
                }
            }

            for (int k = 0; k < 2; k++) { // 위아래
                int nx = cur[0];
                int ny = cur[1];
                int nh = cur[2] + dh[k];

                if (nh < 0 || nh >= h) {
                    continue;
                }

                if (!visited[nx][ny][nh] && matrix[nx][ny][nh] == 0) {
                    visited[nx][ny][nh] = true;
                    zeroCnt--;
                    if (zeroCnt == 0) {
                        System.out.println(day + 1);
                        return;
                    }
                    queue.offer(new int[] {nx, ny, nh, day + 1});
                }
            }
        }
    }
}