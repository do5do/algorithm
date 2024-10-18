import java.util.*;
import java.io.*;

public class Main {
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dist;
    static int n, start, end;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[] {b, c});
        }
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        dist = new int[n + 1];
        bfs();
        System.out.println(dist[end]);
    }
    
    public static void bfs() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {start, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (visited[cur[0]]) {
                continue;
            }
            visited[cur[0]] = true;
            
            for (int[] node : graph.get(cur[0])) {
                if (dist[node[0]] > cur[1] + node[1]) {
                    dist[node[0]] = cur[1] + node[1];
                    pq.offer(new int[] {node[0], dist[node[0]]});
                }
            }
        }
    }
}