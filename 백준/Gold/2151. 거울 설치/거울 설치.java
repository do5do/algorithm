import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] matrix;
    static int[][] door;
    static int[] dx = {1, -1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new char[n][n];
        door = new int[2][2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);

                if (matrix[i][j] == '#') {
                    door[idx++] = new int[] {i, j};
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int[] door1 = door[0];
        int[] door2 = door[1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        for (int i = 0; i < 4; i++) {
            pq.offer(new int[] {door1[0], door1[1], 0, i}); // 거울 설치 횟수, 방향
        }
        boolean[][][] visited = new boolean[n][n][4];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cnt = cur[2];
            int direct = cur[3];

            if (cur[0] == door2[0] && cur[1] == door2[1]) {
                return cnt;
            }

            visited[cur[0]][cur[1]][direct] = true;

            int nx = cur[0] + dx[direct];
            int ny = cur[1] + dy[direct];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            if (!visited[nx][ny][direct] && matrix[nx][ny] != '*') {
                if (matrix[nx][ny] == '!') { // 거울 설치
                    if (direct == 0 || direct == 1) { // 빛의 방향이 상하이면 좌우로 이동 가능
                        pq.offer(new int[] {nx, ny, cnt + 1, 2});
                        pq.offer(new int[] {nx, ny, cnt + 1, 3});
                    } else { // 좌우
                        pq.offer(new int[] {nx, ny, cnt + 1, 0});
                        pq.offer(new int[] {nx, ny, cnt + 1, 1});
                    }
                }

                pq.offer(new int[] {nx, ny, cnt, direct}); // 거울 설치 x
            }
        }

        return -1;
    }
}