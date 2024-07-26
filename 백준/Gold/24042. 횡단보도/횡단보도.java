import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Node>> graph;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, i));
            graph.get(b).add(new Node(a, i));
        }

        dijkstra();
        System.out.println(distance[n]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));
        distance[1] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.cost > distance[cur.index]) {
                continue;
            }
            
            for (Node next : graph.get(cur.index)) {
                int nextIndex = next.index;
                long nextCost;
                if (cur.cost <= next.cost) {
                    nextCost = next.cost + 1;
                } else {
                    nextCost = ((long) Math.ceil(((double) cur.cost - next.cost) / m)) * m + next.cost + 1;
                }

                if (nextCost < distance[nextIndex]) {
                    distance[nextIndex] = nextCost;
                    queue.offer(new Node(nextIndex, nextCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        long cost;

        public Node(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}