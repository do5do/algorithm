import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 무게가 가정 적은 사람과 많은 사람을 같이 태워본다.
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                answer++;
                start++;
                end--;
            } else {
                // 맨 뒷사람만 태운다.
                answer++;
                end--;
            }
        }
        
        return answer;
    }
}