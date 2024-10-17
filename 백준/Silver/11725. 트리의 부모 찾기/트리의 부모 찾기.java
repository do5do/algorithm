import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] parents;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        visited = new boolean[n + 1];
        parents = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parents[i]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void dfs(int parent) {
        visited[parent] = true;
        
        for (int node : graph.get(parent)) {
            if (!visited[node]) {
                parents[node] = parent;
                dfs(node);
            }
        }
    }
}

