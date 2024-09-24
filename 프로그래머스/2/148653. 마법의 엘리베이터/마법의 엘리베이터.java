class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int rest = storey % 10;
            storey /= 10;
            
            if (rest >= 6) {
                answer += 10 - rest;
                storey++;
            } else if (rest <= 4) {
                answer += rest;
            } else { // 5일 때
                int prev = storey % 10;
                if (prev >= 5) {
                    answer += 10 - rest;
                    storey++;
                } else {
                    answer += rest;
                }
            }
        }
        
        return answer;
    }
}