package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Str_1316_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (testCase-- > 0) {
            String str = br.readLine();
            boolean[] bool = new boolean[26]; // default false
            char prev = str.charAt(0); // 이전 문자
            bool[prev - 'a'] = true;
            cnt++;

            for (int i = 1; i < str.length(); i++) {
                char now = str.charAt(i);
                if (bool[str.charAt(i) - 'a'] && prev != now) { // true 이고(이미 나온 문자), 이전 문자와 다를때
                    cnt--;
                    break; // 그룹 함수가 아님
                } else {
                    bool[str.charAt(i) - 'a'] = true;
                    prev = str.charAt(i);
                }
            }
        }
        System.out.println(cnt);
    }
}
