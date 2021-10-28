package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class while_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int temp = N;

        while (true) {
            N = (N % 10) * 10 + ((N / 10) + (N % 10)) % 10;
            cnt++;
            if (N == temp) {
                break;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
        // 처음 풀었을때
//        int one = N / 10;
//        int two = N % 10;
//        int sum = one + two;
//        int last = sum % 10;
//        int result = Integer.parseInt(two +""+last);
//        N = result;
//        cnt++;
