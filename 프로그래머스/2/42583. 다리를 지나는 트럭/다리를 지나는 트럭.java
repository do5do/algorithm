import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int now = 0;
        int nowWeight = 0;
        int idx = 0;
        
        while (idx < truck_weights.length) {
            int truck = truck_weights[idx];
            
            if (queue.size() == bridge_length) {
                nowWeight -= queue.poll();
            } else {
                if (nowWeight + truck <= weight) {
                    queue.offer(truck);
                    nowWeight += truck;
                    idx++;
                } else {
                    queue.offer(0);
                }
                
                now++;
            }
        }
        
        return now + bridge_length;
    }
}