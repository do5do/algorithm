import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < enemy.length; i++) {
            if (k > 0) { // 무적권을 쓴다.
                k--;
                pq.offer(enemy[i]);
                answer++;
            } else {
                if (!pq.isEmpty()) {
                    int num = enemy[i]; // 무찌를 적
                    
                    // 무적권을 쓴 적보다 현재 적이 더 많은 경우 현재 적에 무적권을 쓴다.
                    if (pq.peek() < enemy[i]) {
                        num = pq.poll();
                        pq.offer(enemy[i]);
                    }
                    
                    if (n >= num) {
                        n -= num;
                        answer++;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}