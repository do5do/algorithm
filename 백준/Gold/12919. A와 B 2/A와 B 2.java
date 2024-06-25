import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String a;
    static String b;
    static int answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine(); // target

        dfs(b);
        System.out.println(answer);
    }

    // target을 줄인다.
    public static void dfs(String str) {
        if (str.length() == a.length()) {
            if (a.equals(str)) {
                answer = 1;
            }
            return;
        }

        String newStr;
        if (str.charAt(0) == 'B') {
            newStr = sb.append(str.substring(1)).reverse().toString();
            sb.setLength(0);
            dfs(newStr);
        }

        if (str.charAt(str.length() - 1) == 'A') {
            dfs(str.substring(0, str.length() - 1));
        }
    }
}