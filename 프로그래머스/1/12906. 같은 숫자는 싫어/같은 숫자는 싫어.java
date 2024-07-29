import java.util.*;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int num2 = arr[i];
            if (num != num2) {
                result.add(num);
                num = num2;
            }
        }
        result.add(arr[arr.length - 1]);
        
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}