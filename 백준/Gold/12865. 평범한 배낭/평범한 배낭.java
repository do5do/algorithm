import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= weight[i]) { // 현재 무게(j)에 i번 가방의 무게를 담을 수 있을때
                    int idx = j - weight[i];
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][idx] + value[i]);
                } else { // 없을 때
                    dp[i][j] = dp[i - 1][j]; // 이전 가방의 가치를 넣어줌
                }
            }
        }
        
        System.out.println(dp[n][k]);
    }
}