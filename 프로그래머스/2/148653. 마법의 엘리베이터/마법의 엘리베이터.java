class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int rest = storey % 10;
            storey /= 10;
            
            if (rest <= 4) {
                answer += rest;
            } else if (rest >= 6) {
                answer += (10 - rest);
                storey++;
            } else { // 5일 때
                if (storey % 10 >= 5) {
                    answer += (10 - rest);
                    storey++;
                } else {
                    answer += rest;
                }
            }
        }
        return answer;
    }
}