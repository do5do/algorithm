package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Array_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 과목 개수
        float[] score = new float[N];
        float sum = 0.0f;
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 여러개 입력 공백으로 자름

        for (int i = 0; i < score.length; i++) {
            score[i] = Float.parseFloat(st.nextToken()); // 입력
        }
        Arrays.sort(score); // 정렬
        //System.out.println(Arrays.toString(score));

        for (int i = 0; i < score.length; i++) {
            sum += score[i] * 100 / score[N-1];
        }

        System.out.println(sum/N);
        br.close();
    }
}
