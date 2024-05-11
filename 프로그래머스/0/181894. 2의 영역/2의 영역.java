class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int start = -1;
        int end = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }

        if (start == -1) {
            return new int[] {-1};
        } else {
            answer = new int[end - start + 1];
        }

        int idx = 0;
        for (int i = start; i <= end; i++) {
            answer[idx++] = arr[i];
        }
        return answer;
    }
}