import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int curWeight = 0;
        Queue<Integer> queue = new LinkedList<>(); // 다리
        int idx = 0;
        
        while (idx < truck_weights.length) {
            int truck = truck_weights[idx];
            
            if (queue.isEmpty()) { // 큐가 비어있으면 트럭을 올린다.
                queue.offer(truck);
                curWeight += truck;
                answer++;
                idx++;
            } else if (queue.size() == bridge_length) {
                curWeight -= queue.poll(); // 맨 앞 트럭 나감.
            } else {
                if (curWeight + truck <= weight) {
                    queue.offer(truck);
                    curWeight += truck;
                    idx++;
                } else {
                    queue.offer(0);
                }
                answer++;
            }
        }
        
        return answer + bridge_length; // 마지막 트럭이 다리를 건너는 시간 더해주기
    }
}