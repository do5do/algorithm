import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    static int[][] result;
    static int n, m, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < r; i++) {
            // 공격
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String direction = st.nextToken();
            attack(x, y, direction.charAt(0));

            // 수비
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            result[x][y] = matrix[x][y];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0) {
                    sb.append("F ");
                    continue;
                }

                sb.append("S ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void attack(int x, int y, char direct) {
        if (result[x][y] == 0) { // 이미 쓰러졌으면
            return;
        }

        int dx = 0;
        int dy = 0;
        if (direct == 'E') {
            dy = 1;
        } else if (direct == 'W') {
            dy = -1;
        } else if (direct == 'N') {
            dx = -1;
        } else {
            dx = 1;
        }

        int limit = matrix[x][y]; // 이동할 수
        int nx = x;
        int ny = y;

        while (limit > 0) {
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                break;
            }

            if (result[nx][ny] != 0) {
                answer++; // 쓰러트린 도미노 수 증가
            }

            limit = Math.max(limit, result[nx][ny]);
            limit--;
            result[nx][ny] = 0; // 도미노 쓰러트림

            nx += dx;
            ny += dy;
        }
    }
}