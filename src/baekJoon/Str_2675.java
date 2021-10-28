package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Str_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // test case

        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int len = Integer.parseInt(st.nextToken());
            String word = st.nextToken();

            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < len; j++) {
                    System.out.print(word.charAt(i));
                }
            }
            System.out.println();
        }
        br.close();
    }
}
