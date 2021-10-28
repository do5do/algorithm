package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Str_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        Map<String, Integer> map = new HashMap<>();
        map.put("ABC", 2);
        map.put("DEF", 3);
        map.put("GHI", 4);
        map.put("JKL", 5);
        map.put("MNO", 6);
        map.put("PQRS", 7);
        map.put("TUV", 8);
        map.put("WXYZ", 9);

        int cnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) { // map에서 키와 벨류 가져오기
            for (int i = 0; i < number.length(); i++) {
                if (entry.getKey().contains(Character.toString(number.charAt(i)))) {
                    cnt += entry.getValue() + 1;

                }
            }
        }
        System.out.println(cnt);
    }
}
