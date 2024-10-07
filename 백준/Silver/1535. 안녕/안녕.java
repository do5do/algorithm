import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] power = new int[n + 1];
        int[] happy = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            power[i + 1] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            happy[i + 1] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[n + 1][100];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 100; j++) {
                if (j >= power[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - power[i]] + happy[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        System.out.println(dp[n][99]);
    }
}