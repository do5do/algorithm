import java.io.*;
import java.util.*;

public class Main {
    static int r, c, sheep, wolf;
    static char[][] matrix;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        matrix = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && matrix[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        int sheepCnt = 0;
        int wolfCnt = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (matrix[cur[0]][cur[1]] == 'o') {
                sheepCnt++;
            } else if (matrix[cur[0]][cur[1]] == 'v') {
                wolfCnt++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (!visited[nx][ny] && matrix[nx][ny] != '#') {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        if (sheepCnt > wolfCnt) {
            sheep += sheepCnt;
        } else {
            wolf += wolfCnt;
        }
    }
}