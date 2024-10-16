import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] matrix;
    static int[][][] blocks = {
        {{0,0}, {0,1}, {0,2}, {0,3}},
        {{0,0}, {1,0}, {2,0}, {3,0}},
        {{0,0}, {0,1}, {1,1}, {1,2}},
        {{0,0}, {1,0}, {1,-1}, {2,-1}},
        {{0,0}, {0,1}, {0,2}, {1,2}},
        {{0,0}, {1,0}, {2,0}, {2,-1}},
        {{0,0}, {1,0}, {1,1}, {1,2}},
        {{0,0}, {0,1}, {1,0}, {2,0}},
        {{0,0}, {0,1}, {0,2}, {1,1}},
        {{0,0}, {1,0}, {1,-1}, {2,0}},
        {{0,0}, {1,0}, {1,-1}, {1,1}},
        {{0,0}, {1,0}, {1,1}, {2,0}},
        {{0,0}, {0,1}, {1,0}, {1,1}}
        };
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int step = 0;
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            n = Integer.parseInt(br.readLine().trim());
            if (n == 0) {
                break;
            }
            step++;
            
            matrix = new int[n][n];
            StringTokenizer st;
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken().trim());
                }
            }
            
            int maxSum = Integer.MIN_VALUE;
            
            for (int i = 0; i < blocks.length; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        int sum = getSum(i, j, k);
                        maxSum = Math.max(sum, maxSum);
                    }
                }
            }
            
            sb.append(step).append(". ").append(maxSum).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static int getSum(int idx, int x, int y) {
        int sum = 0;
        
        for (int i = 0; i < blocks[idx].length; i++) {
            int nx = x + blocks[idx][i][0];
            int ny = y + blocks[idx][i][1];
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                return Integer.MIN_VALUE;
            }
            
            sum += matrix[nx][ny];
        }
        
        return sum;
    }
}