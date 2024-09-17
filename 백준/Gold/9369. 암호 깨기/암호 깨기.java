import java.io.*;
import java.util.*;

public class Main {
    static String[] encrypts;
    static String decrypt, target;
    static char[][] match;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while (t > 0) {
            t--;
            int n = Integer.parseInt(br.readLine());
            encrypts = new String[n]; // 암호문

            for (int i = 0; i < n; i++) {
                encrypts[i] = br.readLine();
            }

            decrypt = br.readLine(); // 해독문
            target = br.readLine();

            match = new char[n][26]; // 암호 문자 : 해독 문자
            List<Integer> canDecrypt = new ArrayList<>(); // 해독 가능한 암호문

            for (int i = 0; i < encrypts.length; i++) {
                if (isMatch(i)) {
                    canDecrypt.add(i);
                }
            }

            StringBuilder sb = getResult(canDecrypt);
            answer.append(sb).append("\n");
        }

        System.out.println(answer);
    }

    public static boolean isMatch(int idx) {
        if (decrypt.length() != encrypts[idx].length()) {
            return false;
        }

        boolean[] exists = new boolean[26];
        int cnt = 0;

        for (int i = 0; i < encrypts[idx].length(); i++) {
            int encryptIdx = encrypts[idx].charAt(i) - 'a';

            if (match[idx][encryptIdx] < 'a') {
                if (exists[decrypt.charAt(i) - 'a']) {
                    return false;
                }

                match[idx][encryptIdx] = decrypt.charAt(i); // 매칭되는 해독 문자 넣기
                exists[decrypt.charAt(i) - 'a'] = true;
                cnt++;
            } else {
                if (match[idx][encryptIdx] != decrypt.charAt(i)) {
                    return false;
                }
            }
        }

        if (cnt == 25) { // 25개를 알았다면 나머지 하나도 알 수 있다.
            char c = ' ';
            for (int i = 0; i < exists.length; i++) {
                if (!exists[i]) {
                    c = (char) (i + 'a');
                    break;
                }
            }

            for (int i = 0; i < match[idx].length; i++) {
                if (match[idx][i] < 'a') {
                    match[idx][i] = c;
                    break;
                }
            }
        }

        return true;
    }

    public static StringBuilder getResult(List<Integer> canDecrypt) {
        StringBuilder sb = new StringBuilder();

        if (canDecrypt.isEmpty()) {
            sb.append("IMPOSSIBLE");
        } else if (canDecrypt.size() == 1) {
            int idx = canDecrypt.get(0);
            makeDecrypt(match[idx], sb);
        } else {
            char[] match = new char[26];

            for (int i = 0; i < decrypt.length(); i++) {
                char cur = encrypts[canDecrypt.get(0)].charAt(i);

                for (int j = 1; j < canDecrypt.size(); j++) {
                    if (cur != encrypts[canDecrypt.get(j)].charAt(i)) {
                        break;
                    }

                    if (j == canDecrypt.size() - 1) {
                        match[cur - 'a'] = decrypt.charAt(i);
                    }
                }
            }

            makeDecrypt(match, sb);
        }

        return sb;
    }

    public static void makeDecrypt(char[] match, StringBuilder sb) {
        for (int i = 0; i < target.length(); i++) {
            int targetIdx = target.charAt(i) - 'a';

            if (match[targetIdx] >= 'a') {
                sb.append(match[targetIdx]);
            } else {
                sb.append("?");
            }
        }
    }
}