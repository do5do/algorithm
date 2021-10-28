package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] score = new String[Integer.parseInt(br.readLine())]; // test case 개수

        for (int i = 0; i < score.length; i++) {
            score[i] = br.readLine();
        }

        for (int i = 0; i < score.length; i++) {
            int cnt = 0;
            int sum = 0;
            for (int j = 0; j < score[i].length(); j++) {
                String ox = Character.toString(score[i].charAt(j)).toUpperCase(); // Character.toString(형변환할 char) : char -> String으로 형변환
                if (ox.equals("O")) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                sum += cnt;
            }
            System.out.println(sum);
        }
    }
}
