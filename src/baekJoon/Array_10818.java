package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Array_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[N];
        int max = -1000000;
        int min = 1000000;

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] > max) max = a[i];
            if (a[i] < min) min = a[i];
        }

        System.out.println(min+" "+max);
        br.close();
    }
}
