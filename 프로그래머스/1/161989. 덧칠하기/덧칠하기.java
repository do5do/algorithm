class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int start = 1;
        boolean[] paint = new boolean[n + 1];
        
        for (int i = 0; i < section.length; i++) {
            paint[section[i]] = true;
        }
        
        while (start <= n) {
            if (paint[start]) {
                answer++;
                start += m;
            } else {
                start++;
            }
        }
        return answer;
    }
}