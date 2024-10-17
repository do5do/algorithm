import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] count;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] query = new int[q];
        for (int i = 0; i < q; i++) {
            query[i] = Integer.parseInt(br.readLine());
        }
        
        visited = new boolean[n + 1];
        count = new int[n + 1];
        dfs(root);
        
        StringBuilder sb = new StringBuilder();
        for (int node : query) {
           sb.append(count[node]).append("\n"); 
        }
        System.out.println(sb);
    }
    
    public static int dfs(int parent) {
        visited[parent] = true;
        count[parent]++;
        
        for (int node : graph.get(parent)) {
            if (visited[node]) {
                continue;
            }
            
            count[parent] += dfs(node);
        }
        
        return count[parent];
    }
}