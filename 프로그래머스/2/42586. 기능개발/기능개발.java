import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < speeds.length; i++) {
            int restProgress = 100 - progresses[i];
            int day = restProgress / speeds[i]; // 남은 일수
            int mod = restProgress % speeds[i];
            if (mod > 0) {
                day++;
            }
            
            queue.offer(day);
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int cnt = 1;
            
            while (!queue.isEmpty() && queue.peek() <= cur) {
                cnt++;
                queue.poll();
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