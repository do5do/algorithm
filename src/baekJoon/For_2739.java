package baekJoon;

import java.util.Scanner;

public class For_2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("구구단 몇단?");
        int n = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
            System.out.println(n+" * "+i+" = "+(n*i));
        }
        sc.close();
    }
}
