import java.util.*;

class Solution {
    int[] answer;
    int maxDiff = -1;
    int diff;

    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        dfs(0, n, info, new int[info.length]);

        if (maxDiff == -1) {
            answer = new int[] {-1};
        }
        return answer;
    }

    public void dfs(int depth, int n, int[] info, int[] result) {
        if (depth == info.length || 0 == n) {
            if (!isWin(info, result)) {
                return;
            }

            // 점수 확인
            if (maxDiff < diff) {
                answer = Arrays.copyOf(result, result.length);
                maxDiff = diff;
            } else if (maxDiff == diff) {
                for (int i = result.length - 1; i >= 0; i--) {
                    if (result[i] > answer[i]) {
                        answer = Arrays.copyOf(result, result.length);
                        break;
                    } else if (result[i] < answer[i]) {
                        break;
                    }
                }
            }
            return;
        }

        for (int i = n; i >= 0; i--) {
            result[depth] = i;
            dfs(depth + 1, n - i, info, result);
        }
    }

    public boolean isWin(int[] info, int[] result) {
        int score1 = 0;
        int score2 = 0; // lion

        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0 && result[i] == 0) {
                continue;
            }
            int score = 10 - i;

            if (info[i] >= result[i]) {
                score1 += score;
            } else {
                score2 += score;
            }
        }

        if (score1 < score2) {
            diff = score2 - score1;
            return true;
        }
        return false;
    }
}