class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String a = s.substring(0, i);
            int cnt = 1;
            
            for (int j = i; j <= s.length(); j += i) {
                int endIdx = j + i;
                if (endIdx > s.length()) {
                    endIdx = s.length();
                }
                String b = s.substring(j, endIdx);
                
                if (a.equals(b)) {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        sb.append(cnt);
                    }
                    sb.append(a);
                    if (b.length() < i) {
                        sb.append(b);
                    } else {
                        a = b;
                        cnt = 1;
                    }
                }
            }
            
            answer = Math.min(sb.length(), answer);
        }
        return answer;
    }
}