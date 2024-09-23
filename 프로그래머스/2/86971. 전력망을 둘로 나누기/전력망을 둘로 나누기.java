import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    int cnt;
    
    public int solution(int n, int[][] wires) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList());
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int diff = Integer.MAX_VALUE;
        
        for (int[] wire : wires) {
            visited = new boolean[n + 1];
            cnt = 0;
            
            dfs(wire[0], wire);
            diff = Math.min(diff, Math.abs(cnt - (n - cnt)));
        }
        return diff;
    }
    
    public void dfs(int parent, int[] cut) {
        visited[parent] = true;
        cnt++;
        
        for (int node : graph.get(parent)) {
            if (!visited[node]) {
                if (parent == cut[0] && node == cut[1]) {
                    continue;
                }
                dfs(node, cut);
            }
        }
    }
}