import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] heights = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] sums = new int[n]; // 누적합
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            sums[a - 1] += k;
            if (b < n) {
                sums[b] += -k;
            }
        }
        
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + sums[i];
        }
        
        for (int i = 0; i < n; i++) { // 기존 높이 더해주기
            sums[i] += heights[i];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int height : sums) {
            sb.append(height).append(" ");
        }
        
        System.out.println(sb);
    }
}