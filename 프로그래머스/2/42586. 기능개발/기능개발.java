import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int restTime = 100 - progresses[i];
            int time = restTime / speeds[i];
            if (restTime % speeds[i] > 0) {
                time++;
            }
            queue.offer(time);
        }
        
        List<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int cnt = 1;
            
            while (!queue.isEmpty() && queue.peek() <= cur) {
                queue.poll();
                cnt++;
            }
            
            result.add(cnt);
        }
        
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}