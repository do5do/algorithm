package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Str_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[26];
        Arrays.fill(result, -1); // default value setting
        String word = br.readLine(); // 문자 입력
        int num = 97;

        for (int i = 0; i < result.length; i++) {
            char chNum = (char) num; // 아스키코드로 변환 97 -> a
            for (int j = 0; j < word.length(); j++) {
//                if (Character.toString(chNum).equals(Character.toString(word.charAt(j)))) {
                if (chNum == word.charAt(j)) {
                    result[i] = j;
                    break;
                }
            }
            num++;
        }
        for (int r : result) { // 출력
            System.out.print(r+" ");
        }
        //System.out.println(Arrays.toString(result));
        br.close();
    }
}
