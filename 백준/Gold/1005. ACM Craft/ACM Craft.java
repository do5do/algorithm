import java.io.*;
import java.util.*;

public class Main {
    static int[] time;
    static List<List<Integer>> graph;
    static int[] indeg;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t > 0) {
            t--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            time = new int[n + 1];
            indeg = new int[n + 1];
            dp = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                indeg[b]++;
            }

            int targetNode = Integer.parseInt(br.readLine());
            setTime();
            sb.append(dp[targetNode]).append("\n");
        }

        System.out.println(sb);
    }

    private static void setTime() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
                dp[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int node : graph.get(cur)) {
                indeg[node]--;

                if (indeg[node] == 0) {
                    queue.offer(node);
                }
                dp[node] = Math.max(dp[node], dp[cur] + time[node]);
            }
        }
    }
}
