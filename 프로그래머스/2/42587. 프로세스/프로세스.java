import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] arr = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(arr);
        int max = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            max = Math.max(priorities[i], max);
            queue.offer(new int[] {priorities[i], i});
        }
        
        int idx = arr.length - 1;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
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
            } else {
                queue.offer(cur);
            }
        }
        
        return answer;
    }
}