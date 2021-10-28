package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math1_1712_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int fixed = Integer.parseInt(st.nextToken());
        int variable = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        int cnt;

        if (price <= variable) {
            cnt = -1;
        } else {
            cnt = (fixed / (price - variable) + 1);
        }

        System.out.println(cnt);
    }
}
