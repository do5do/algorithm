class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int start = -1;
        int end = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (start == -1) {
                    start = i;
                } else if (start > -1) {
                    end = i;
                }
            }
        }
        
        if (start == -1 && end == -1) {
            answer = new int[] {-1};
        } else if (start > -1 && end == -1) {
            answer = new int[1];
            answer[0] = arr[start];
        } else {
            answer = new int[end - start + 1];
            int idx = 0;
            for (int i = start; i <= end; i++) {
                answer[idx++] = arr[i];
            }  
        }
        
        return answer;
    }
}