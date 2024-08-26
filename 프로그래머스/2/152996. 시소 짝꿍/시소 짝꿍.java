import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        double[] arr = new double[4];
        
        // 1:1, 2:3, 2:4(= 1:2), 3:4
        for (int weight : weights) {
            arr[0] = weight * 1.0;
            arr[1] = (weight * 1.0) / 2.0;
            arr[2] = (weight * 2.0) / 3.0;
            arr[3] = (weight * 3.0) / 4.0;
            
            for (double num : arr) {
                if (map.containsKey(num)) {
                    answer += map.get(num);
                }
            }
            
            map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
        }
        
        return answer;
    }
}