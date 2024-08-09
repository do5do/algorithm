import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] left = new int[] {3, 0};
        int[] right = new int[] {3, 2};
        
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                left[0] = number / 3;
                left[1] = 0;
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                right[0] = number / 3 - 1;
                right[1] = 0;
            } else {
                int[] num = new int[2];
                
                if (number == 0) {
                    num[0] = 3;
                    num[1] = 1;
                } else {
                    num[0] = number / 3;
                    num[1] = 1;
                }
                
                int leftDiff = Math.abs(num[0] - left[0]) + Math.abs(num[1] - left[1]);
                int rightDiff = Math.abs(num[0] - right[0]) + Math.abs(num[1] - right[1]);
                
                if (leftDiff < rightDiff) {
                    sb.append("L");
                    left = num;
                } else if (leftDiff > rightDiff) {
                    sb.append("R");
                    right = num;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = num; 
                    } else {
                        sb.append("R");
                        right = num;
                    }
                }
            }
        }
        
        return sb.toString();
    }
}