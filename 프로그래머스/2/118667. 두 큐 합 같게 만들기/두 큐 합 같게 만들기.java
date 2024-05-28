import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sum1 = 0;
        long sum2 = 0;
        int cnt = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];

            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (cnt >= (queue1.length + queue2.length) * 3) {
                break;
            }
            
            if (sum1 < sum2) {
                int num = q2.poll();
                q1.offer(num);
                sum1 += num;
                sum2 -= num;
            } else if (sum1 > sum2) {
                int num = q1.poll();
                q2.offer(num);
                sum1 -= num;
                sum2 += num;
            } else {
                answer = cnt;
                break;
            }

            cnt++;
        }

        return answer;
    }
}