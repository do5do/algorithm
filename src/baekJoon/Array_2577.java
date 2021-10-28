package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        String result = Integer.toString(A * B * C);

        for (int i = 0; i <= 9; i++) {
            int cnt = 0;
            for (int j = 0; j < result.length(); j++) {
                if ((result.charAt(j) - '0') == i) {
                    // result.charAt(0) = '1' 이렇게 된다. 이건 49가 나온다는 것. 근데 내가 원하는 숫자는 1이기에 - '0' 즉 48을 빼준다.
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

        br.close();
    }
}
