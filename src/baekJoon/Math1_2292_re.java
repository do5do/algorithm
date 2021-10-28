package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math1_2292_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int cnt = 1;
        int num = 2;

        while (input >= num) {
            num += 6*cnt;
            cnt++;
        }

        System.out.println(cnt);
    }
}
