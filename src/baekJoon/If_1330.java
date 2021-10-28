package baekJoon;

import java.util.Scanner;

public class If_1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("두 정수를 입력하여주세요.");
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(A+" "+B);

        if (A > B) {
            System.out.println(">");
        } else if (A < B) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
        sc.close();
    }
}
