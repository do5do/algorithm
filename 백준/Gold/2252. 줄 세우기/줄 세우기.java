import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] indeg = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indeg[b]++;
        }
        
        Queue<Integer> queue = new LinkedList<>(); // 들어오는 간선이 없는 노드 저장
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            
            for (int node : graph.get(cur)) { // cur -> node
                indeg[node]--;
                
                if (indeg[node] == 0) {
                    queue.offer(node);
                }
            }
        }
        
        System.out.println(sb);
    }
}