import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    int[][] dp;

    public int solution(int n, int[][] lighthouse) {
        int answer = 0;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < lighthouse.length; i++) {
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n + 1];
        dp = new int[n + 1][2]; // i:node, j:0(불을 안킨 경우 노드 개수) or 1(불을 킨 경우 노드 개수)
        dfs(1);
        answer = Math.min(dp[1][0], dp[1][1]);
        return answer;
    }

    public void dfs(int x) {
        visited[x] = true;
        dp[x][1] = 1;

        for (int node : graph.get(x)) {
            if (!visited[node]) {
                dfs(node);
                dp[x][0] += dp[node][1]; // 현재 노드의 불을 안 킨경우 자식 노드의 불을 킨다.
                dp[x][1] += Math.min(dp[node][0], dp[node][1]); // 현재 노드가 켜져있다면 자식 노드의 최소값을 가진다.
            }
        }
    }
}