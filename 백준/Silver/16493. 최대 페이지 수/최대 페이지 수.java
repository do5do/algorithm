import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 챕터 수
        
        int[] days = new int[m + 1];
        int[] pages = new int[m + 1];
        
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[m + 1][n + 1]; // [챕터][일수]
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) { // 현재 일에 최대 페이지 수
                if (j >= days[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - days[i]] + pages[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        System.out.println(dp[m][n]);
    }
}