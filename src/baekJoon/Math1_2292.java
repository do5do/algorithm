package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int n = 0;

        while (input > ((6 + 6*n) / 2 * n + 1)) { // 계차수열 일반항이 입력값보다 커지면 탈출
            n++;
        }
        System.out.println(n+1);
    }
}
