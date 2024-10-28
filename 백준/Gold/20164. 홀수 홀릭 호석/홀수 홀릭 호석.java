import java.io.*;

public class Main {
    static int oddCnt;
    static String n;
    static int max = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        go();
        System.out.println(min + " " + max);
    }

    public static void go() {
        countOdd(); // 홀수 개수 확인

        if (n.length() == 1) {
            max = Math.max(max, oddCnt);
            min = Math.min(min, oddCnt);
        } else if (n.length() == 2) {
            int first = n.charAt(0) - '0';
            int second = n.charAt(1) - '0';
            n = String.valueOf(first + second);
            go();
        } else if (n.length() >= 3) {
            for (int i = 0; i <= n.length() - 3; i++) {
                for (int j = i + 1; j <= n.length() - 2; j++) {
                    String first = n.substring(i, i + 1);
                    String second = n.substring(j, j + 1);
                    String third = n.substring(j + 1);
                    int sum = Integer.parseInt(first) + Integer.parseInt(second) + Integer.parseInt(third);
                    n = String.valueOf(sum);
                    go();
                }
            }
        }
    }

    public static void countOdd() {
        int cnt = 0;
        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if (num % 2 == 1) {
                cnt++;
            }
        }
        oddCnt += cnt;
    }
}