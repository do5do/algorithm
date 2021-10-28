package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class For_10950_Buff {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // console에서 입력 받을 경우
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st; // 문자열 자르기 split() 보다 성능이 좋음
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " "); // 새로 입력 받는 것을 공백을 기준으로 잘라줌
            // 자른거끼리 더하여 빌더에 저장
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
