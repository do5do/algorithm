import java.util.*;

class Solution {
    int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        Arrays.sort(costs, (x, y) -> x[2] - y[2]);
        
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            if (find(a) != find(b)) {
                union(a, b);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
    
    public int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        
        return parents[a] = find(parents[a]);
    }
}