import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};
        Set<Integer> arrSet = new LinkedHashSet<>(Arrays.stream(arr)
                                            .boxed().collect(Collectors.toList()));
        Set<Integer> delSet = new LinkedHashSet<>(Arrays.stream(delete_list)
                                            .boxed().collect(Collectors.toList()));
        
        arrSet.removeAll(delSet);
        
        answer = new int[arrSet.size()];
        int idx = 0;
        for (int a : arrSet) {
            answer[idx++] = a;
        }
        return answer;
    }
}