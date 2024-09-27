import java.util.*;

class Solution {
    boolean[] visited;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];
        
        for (int card : cards) {
            if (visited[card - 1]) {
                continue;
            }
            
            int num = find(card - 1, 0, cards);
            pq.add(num);
        }
        
        if (pq.size() < 2) {
            return answer;
        }
        return pq.poll() * pq.poll();
    }
    
    public int find(int idx, int cnt, int[] cards) {
        if (visited[idx]) {
            return cnt;
        }
        
        visited[idx] = true;
        return find(cards[idx] - 1, cnt + 1, cards);
    }
}