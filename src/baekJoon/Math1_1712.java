package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math1_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long fixed = Integer.parseInt(st.nextToken());
        long variable = Integer.parseInt(st.nextToken());
        long price = Integer.parseInt(st.nextToken());
        int cnt = 1;

        while (fixed + variable * cnt >= price * cnt) { // 생산금액이 판매금액보다 작아지면 루프 탈출
            if (price <= variable) {
                cnt = -1;
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
