package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int n = 0, cnt = 0; // n 행 번호

        while (true) {
            n++;
            cnt += n; // 해당 행까지 항의 합 (개수)

            if (cnt >= input) { // cnt는 input보다 크거나 같을때에만 계산함
                if (n % 2 == 0) { // 짝수 행
                    System.out.println(input - cnt + n +"/"+(cnt - input + 1));
                } else { // 홀수 행
                    System.out.println(cnt - input + 1 +"/"+(input - cnt + n));
                }
                break;
            }
        }
    }
}
