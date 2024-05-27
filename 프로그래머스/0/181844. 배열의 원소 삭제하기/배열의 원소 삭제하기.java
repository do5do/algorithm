import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};
        Set<Integer> set1 = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toCollection(LinkedHashSet::new));
        
        Set<Integer> set2 = Arrays.stream(delete_list)
            .boxed()
            .collect(Collectors.toCollection(LinkedHashSet::new));
        
        set1.removeAll(set2);

        answer = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1) {
            answer[idx++] = s;
        }
        return answer;
    }
}