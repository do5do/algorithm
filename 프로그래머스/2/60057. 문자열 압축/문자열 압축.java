class Solution {
    public int solution(String s) {
        int answer = s.length();
        StringBuilder sb;
        
        for (int i = 1; i < s.length(); i++) {
            sb = new StringBuilder();
            String str = s.substring(0, i);
            int cnt = 1;

            for (int j = i; j < s.length(); j += i) {
                int end = j + i;
                if (end > s.length() - 1) {
                    end = s.length();
                }

                String next = s.substring(j, end);

                if (str.equals(next)) {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        sb.append(cnt);
                    }
                    sb.append(str);
                    str = next;
                    cnt = 1;
                }
            }

            if (cnt >= 2) { // 마지막 문자
                sb.append(cnt);
            }
            sb.append(str);

            answer = Math.min(sb.length(), answer);
        }
        return answer;
    }
}