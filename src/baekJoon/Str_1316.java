package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Str_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] str = new String[testCase];
        int cnt = 0;

        for (String st : str) {
            st = br.readLine();
            cnt++;
            st : for (int i = 0; i < st.length(); i++) {
                for (int j = i+1; j < st.length(); j++) {
                    if (st.charAt(i) == st.charAt(j) && j - i > 1 && st.charAt(j) != st.charAt(j-1)) { // 앞에 문자와 같은게 있다. 근데 연속되는게 아니다.
                        cnt--;
                        break st;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
