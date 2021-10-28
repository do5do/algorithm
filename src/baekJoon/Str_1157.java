package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Str_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        int[] ab = new int[26];
        int max = 0;
        char result = '?';

        for (int i = 0; i < str.length(); i++) {
            ab[str.charAt(i) - 'A']++;
        }
        //System.out.println(Arrays.toString(ab));

        for (int i = 0; i < ab.length; i++) {
            if (ab[i] > max) {
                max = ab[i]; // 가장 큰 값을 가지고 있으면 출력
                result = (char) (i + 'A');
            } else if (ab[i] == max) { // max값이 또 있으면 물음표
              result = '?';
            }
        }

        System.out.println(result);
        br.close();
    }
}
