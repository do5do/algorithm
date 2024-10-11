import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] arr = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(arr);
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {priorities[i], i});
        }
        
        int idx = arr.length - 1;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            // 231421
            if (cur[0] < arr[idx]) {
                queue.offer(cur);
            } else if (cur[0] == arr[idx]) {
                answer++;
                if (location == cur[1]) {
                    return answer;
                }
                idx--;
                
                if (idx < 0) {
                    break;
                }
            }
        }
        
        return answer;
    }
}