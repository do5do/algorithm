import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {priorities[i], i});
        }
        
        while (!queue.isEmpty()) {
            int max = 0;
            for (int[] num : queue) {
                max = Math.max(num[0], max);
            }
            
            while (!queue.isEmpty() && queue.peek()[0] < max) {
                queue.offer(queue.poll()); // 뒤로 넣기
            }
            
            // max를 찾았으면
            int[] maxNum = queue.poll();
            if (maxNum[1] == location) {
                return answer;
            }
            answer++;
        }
        
        return answer;
    }
}