import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        
        int maxNum = 0;
        for (int[] edge : edges) {
            maxNum = Math.max(Math.max(edge[0], edge[1]), maxNum);
        }
        
        for (int i = 0; i <= maxNum; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] incomeEdges = new int[maxNum + 1]; // 들어오는 간선의 수
        Arrays.fill(incomeEdges, -1);
        
        for (int[] edge : edges) { // 노드의 번호가 연속되지 않을 수 있다.
            incomeEdges[edge[0]] = 0;
            incomeEdges[edge[1]] = 0;
        }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            graph.get(a).add(b);
            incomeEdges[b]++;
        }
        
        // 생성한 정점 찾기
        int newVertex = 0;
        for (int i = 1; i <= maxNum; i++) {
            // 나가는 간선은 두개 이상 존재, 들어오는 간선은 없다.
            if (graph.get(i).size() >= 2 && incomeEdges[i] == 0) {
                newVertex = i;
                break;
            }
        }
        
        // 생성한 정점과 연결 끊기
        for (int node : graph.get(newVertex)) {
            incomeEdges[node]--;
        }
        
        // 막대 노드 찾기 -> 시작 노드는 들어오는 간선이 없다.
        int bar = 0;
        for (int i = 1; i <= maxNum; i++) {
            if (i == newVertex) {
                continue;
            }
            
            if (incomeEdges[i] == 0) {
                bar++;
            }
        }
        
        // 8자 노드 찾기 -> 8자 그래프에는 나가는 간선이 2개, 들어오는 간선이 2개인 노드가 존재한다.
        int eight = 0;
        for (int i = 1; i <= maxNum; i++) {
            if (incomeEdges[i] == 2 && graph.get(i).size() == 2) {
                eight++;
            }
        }
        
        int totalGraph = graph.get(newVertex).size(); // 전체 그래프 개수
        int doughnut = totalGraph - (bar + eight);
        return new int[] {newVertex, doughnut, bar, eight};
    }
}