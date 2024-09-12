import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        long target = (sum1 + sum2) / 2;
        
        while (answer <= (queue1.length) * 3) {
            if (sum1 > sum2) {
                if (!q1.isEmpty()) {
                    int item = q1.poll();
                    q2.offer(item);
                    sum1 -= item;
                    sum2 += item;
                    answer++;
                }
            } else if (sum1 < sum2) {
                if (!q2.isEmpty()) {
                    int item = q2.poll();
                    q1.offer(item);
                    sum1 += item;
                    sum2 -= item;
                    answer++;
                }
            }
            
            if (sum1 == sum2 && sum1 == target) {
                return answer;
            }
        }
        
        if (sum1 != sum2) {
            return -1;
        }
        return answer;
    }
}