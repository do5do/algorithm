package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array_2562 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
                index = i+1;
            }
        }
        br.close();
        System.out.println(max);
        System.out.println(index);
    }
}
