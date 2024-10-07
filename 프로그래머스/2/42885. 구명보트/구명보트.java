import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 가장 무거운 사람 + 가장 가벼운 사람을 같이 태워본다.
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            if (left == right) {
                answer++;
                break;
            }
            
            if (people[right] + people[left] <= limit) {
                answer++;
                right--;
                left++;
            } else {
                answer++;
                right--;
            }
        }
        
        return answer;
    }
}