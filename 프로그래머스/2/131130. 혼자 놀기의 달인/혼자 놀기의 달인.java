import java.util.*;

class Solution {
    boolean[] visited;
    List<int[]> selected = new ArrayList<>();
    
    public int solution(int[] cards) {
        int answer = 0;
        
        // 조합. 2개 선택
        select(0, cards.length, 2, new boolean[cards.length]);
        
        for (int[] nums : selected) {
            visited = new boolean[cards.length];
            
            int first = find(cards[nums[0]] - 1, 0, cards);
            int second = find(cards[nums[1]] - 1, 0, cards);
            
            answer = Math.max(answer, first * second);
        }
        
        return answer;
    }
    
    public void select(int start, int n, int r, boolean[] visited) {
        if (r == 0) {
            int[] result = new int[2];
            int idx = 0;
            
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    result[idx++] = i;
                }
            }
            
            selected.add(result);
            return;
        }
        
        for (int i = start; i < n; i++) {
            visited[i] = true;
            select(i + 1, n, r - 1, visited);
            visited[i] = false;
        }
    }
    
    public int find(int idx, int cnt, int[] cards) {
        if (visited[idx]) {
            return cnt;
        }
        
        visited[idx] = true;
        return find(cards[idx] - 1, cnt + 1, cards);
    }
}