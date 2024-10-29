import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        bfs(destination);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
    
    public void bfs(int dest) {
        dist[dest] = 0;
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(dest);
        
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            
            for (int node : graph.get(cur)) {
                if (dist[node] == -1) {
                    dist[node] = dist[cur] + 1;
                    pq.offer(node);
                }
            }
        }
    }
}