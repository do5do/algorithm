package programers.level1;

import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumStringEng {
    public static void main(String[] args) {
        int answer = 0;
        String s = "one4seveneight";
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            map.put(eng[i], String.valueOf(i)); // setting
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            Pattern pattern = Pattern.compile(entry.getKey()); // 패턴
            Matcher matcher = pattern.matcher(s);

            while(matcher.find()) {
                s = matcher.replaceAll(entry.getValue());
            }
        }

        answer = Integer.parseInt(s);
        System.out.println(answer);
    }
}
