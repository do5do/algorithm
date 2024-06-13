import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            graph[e[0]].add(new int[] {e[1], 1});
            graph[e[1]].add(new int[] {e[0], 1});
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {1, 0});
        boolean[] visited = new boolean[n + 1];
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (visited[cur[0]]) {
                continue;
            }
            visited[cur[0]] = true;
            
            for (int[] node : graph[cur[0]]) {
                if (dist[node[0]] > cur[1] + node[1]) {
                    dist[node[0]] = cur[1] + node[1];
                    pq.offer(new int[] {node[0], dist[node[0]]});
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                max = Math.max(dist[i], max);
            }
        }
        
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}