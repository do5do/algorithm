class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int start = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                start = i;
                break;
            }
        }

        int end = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                end = i;
                break;
            }
        }

        if (start == -1 && end == -1) {
            return new int[] {-1};
        } else if (start != -1 && end == -1) {
            return new int[] {arr[start]};
        } else if (start == -1 && end != -1) {
            return new int[] {arr[end]};
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