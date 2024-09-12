import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] jewelry = new int[n][2];
        int[] bags = new int[k];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            
            jewelry[i] = new int[] {weight, price};
        }
        
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(jewelry, (x, y) -> { // 무게 asc, 가격 desce
            int result = x[0] - y[0];
            if (result == 0) {
                result = y[1] - x[1];
            }
            return result;
        });
        
        Arrays.sort(bags);
        
        int idx = 0;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int bag : bags) {
            while (idx < n && bag >= jewelry[idx][0]) {
                pq.offer(jewelry[idx][1]);
                idx++;
            }
            
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        
        System.out.println(sum);
    }
}