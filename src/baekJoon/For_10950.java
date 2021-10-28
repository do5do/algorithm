package baekJoon;

import java.util.Scanner;

public class For_10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] sum = new int[t];

        for (int i = 0; i < sum.length; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sum[i] = a+b;
        }
        sc.close();

        for (int s : sum) {
            System.out.println(s);
        }
    }
}
