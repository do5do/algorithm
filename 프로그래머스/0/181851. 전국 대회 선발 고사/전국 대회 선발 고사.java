import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                pq.offer(new int[] {i, rank[i]});
            }
        }
        
        int a = pq.poll()[0];
        int b = pq.poll()[0];
        int c = pq.poll()[0];
        return 10000 * a + 100 * b + c;
    }
}