import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) {
                pq.offer(new int[] {rank[i], i});
            }
        }
        answer = 10000 * pq.poll()[1] + 100 * pq.poll()[1] + pq.poll()[1];
        return answer;
    }
}