import java.util.*;

class Solution {
    List<List<int[]>> graph = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph.get(a).add(new int[] {b, c});
            graph.get(b).add(new int[] {a, c});
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        bfs(dist, N);
        
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int[] dist, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {1, 0});
        dist[1] = 0;
        boolean[] visited = new boolean[n + 1];
        
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