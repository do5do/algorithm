class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for (int i = 0; i < my_string.length(); i++) {
            int num = my_string.charAt(i) - '0';
            if (num >= 0 && num <= 9) {
                int j = i + 1;
                while (j < my_string.length()) {
                    int next = my_string.charAt(j) - '0';
                    if (next >= 0 && next <= 9) {
                        j++;
                        num = num * 10 + next;
                        i = j;
                    } else {
                        break;
                    }
                }
                
                answer += num;
            }
        }
        return answer;
    }
}