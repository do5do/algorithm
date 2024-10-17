import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int root, removeNode, leaf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }

            graph.get(parent).add(i);
        }

        removeNode = Integer.parseInt(br.readLine());
        if (removeNode == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(leaf);
    }

    public static void dfs(int parent) {
        List<Integer> nodes = graph.get(parent);

        if (nodes.isEmpty()) {
            leaf++;
        } else if (nodes.size() == 1) {
            if (nodes.get(0) == removeNode) {
                leaf++;
            }
        }
        
        for (int node : nodes) {
            if (node != removeNode) {
                dfs(node);
            }
        }
    }
}
