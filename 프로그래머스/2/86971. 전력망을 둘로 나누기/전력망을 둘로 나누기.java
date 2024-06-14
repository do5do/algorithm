import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int cnt = 0;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int[] delete = wires[i];
            
            if (!visited[i]) {
                dfs(delete[0], delete);
                // System.out.println(cnt);
            }
            
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            cnt = 0;
            visited = new boolean[n + 1];
        }
        
        return answer;
    }
    
    public void dfs(int node, int[] delete) {
        visited[node] = true;
        cnt++;
        
        for (int child : graph[node]) {
            if (!visited[child]) {
                if (node == delete[0] && child == delete[1]) {
                    continue;
                }
                dfs(child, delete);
            }
        }
    }
}