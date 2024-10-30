import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] matrix;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        matrix = new char[n][m];
        String[] query = new String[k];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < k; i++) {
            query[i] = br.readLine();
        }

        // 나올 수 있는 문자열의 개수를 미리 구한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, String.valueOf(matrix[i][j]), 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String q : query) {
            if (map.containsKey(q)) {
                sb.append(map.get(q)).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y, String str, int len) {
        if (len == 6) { // 문자열 길이는 최대 5까지
            return;
        }

        map.put(str, map.getOrDefault(str, 0) + 1);

        for (int i = 0; i < 8; i++) {
            int nx = (x + dx[i]) % n;
            int ny = (y + dy[i]) % m;

            if (nx < 0) {
                nx += n;
            }
            if (ny < 0) {
                ny += m;
            }

            dfs(nx, ny, str + matrix[nx][ny], len + 1);
        }
    }
}