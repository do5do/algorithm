package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Str_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();

        StringBuilder sb = new StringBuilder(A);
        //StringBuilder sb2 = new StringBuilder(B);
        int num1 = Integer.parseInt(sb.reverse().toString()); // 문자열 뒤집기
        int num2 = Integer.parseInt(new StringBuilder(B).reverse().toString());

        System.out.println(Math.max(num1, num2)); // 둘중에 큰 수 출력
    }
}
