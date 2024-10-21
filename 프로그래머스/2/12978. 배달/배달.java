import java.util.*;

class Solution {
    List<List<int[]>> graph = new ArrayList<>();
    int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 1; // 1번 포함
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            graph.get(r[0]).add(new int[] {r[1], r[2]});
            graph.get(r[1]).add(new int[] {r[0], r[2]});
        }
        
        dist = new int[N + 1];
        bfs();
        
        for (int i = 2; i <= N; i++) {
            if (dist[i] > 0 && dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {1, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (dist[cur[0]] != cur[1]) {
                continue;
            }
            
            for (int[] node : graph.get(cur[0])) {
                if (dist[node[0]] > cur[1] + node[1]) {
                    dist[node[0]] = cur[1] + node[1];
                    pq.offer(new int[] {node[0], dist[node[0]]});
                }
            }
        }
    }
}