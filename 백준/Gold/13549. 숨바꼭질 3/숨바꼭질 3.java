import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {n, 0});
        boolean[] visited = new boolean[100001];
        visited[n] = true;
        int[] step = new int[3];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == k) {
                answer = Math.min(cur[1], answer);
            }

            step[0] = cur[0] * 2;
            step[1] = cur[0] - 1;
            step[2] = cur[0] + 1;

            for (int i = 0; i < 3; i++) {
                int nx = step[i];

                if (nx >= 0 && nx < visited.length && !visited[nx]) {
                    visited[nx] = true;
                    if (i == 0) {
                        queue.offer(new int[] {nx, cur[1]});
                    } else {
                        queue.offer(new int[] {nx, cur[1] + 1});
                    }
                }
            }
        }
    }
}
