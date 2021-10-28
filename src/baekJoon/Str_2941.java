package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Str_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;

        for (int i = str.length()-1; i >= 0; i--) {
            if (str.charAt(i) != '=' && str.charAt(i) != '-') {
                cnt++;
                if (str.charAt(i) == 'd' && i <= str.length()-3) { // bounds에러를 막기위해 길이 설정
                    if (str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') {
                        cnt--;
                    }
                } else if ((str.charAt(i) == 'l' || str.charAt(i) == 'n') && i <= str.length()-2) { // bounds에러를 막기위해 길이 설정
                    if (str.charAt(i+1) == 'j') {
                        cnt--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
