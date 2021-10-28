package baekJoon;

import java.util.Scanner;

public class If_2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("년도를 입력해주세요.");
            int year = sc.nextInt();

            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

            if (year == 0 || year > 4000) {
                break;
            }
        }

        sc.close();
    }
}
