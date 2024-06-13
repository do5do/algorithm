import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int weight = road[i][2];
            graph[a].add(new int[] {b, weight});
            graph[b].add(new int[] {a, weight});
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {1, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (visited[cur[0]]) {
                continue;
            }
            visited[cur[0]] = true;
            
            for (int[] node : graph[cur[0]]) {
                if (dist[node[0]] > node[1] + cur[1]) {
                    dist[node[0]] = node[1] + cur[1];
                    pq.offer(new int[] {node[0], dist[node[0]]});
                }
            }
        }
        
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}