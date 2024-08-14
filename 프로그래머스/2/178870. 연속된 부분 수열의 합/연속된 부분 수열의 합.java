import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] arr = Arrays.copyOf(sequence, sequence.length + 1);
        int n = arr.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;
        
        while (left <= right && right < n) {
            if (sum < k) {
                sum += arr[right];
                right++;
            } else {
                sum -= arr[left];
                left++;
            }
            
            if (sum == k) {
                int diff = right - left;
                
                if (minDiff > diff) {
                    answer[0] = left;
                    answer[1] = right - 1;
                    minDiff = diff;
                }
            }
        }
        
        return answer;
    }
}