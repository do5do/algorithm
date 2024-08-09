class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] count = new boolean[10];
        for (int number : numbers) {
            count[number] = true;
        }
        
        for (int i = 0; i < 10; i++) {
            if (!count[i]) {
                answer += i;
            }
        }
        return answer;
    }
}