package baekJoon;

import java.util.Scanner;

public class If_14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("x,y 좌표를 입력해주세요.");
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x < -1000 || x > 1000 || x == 0) {
                System.out.println("범위를 벗어났습니다.");
                break;
            } else if (y < -1000 || y > 1000 || y == 0) {
                System.out.println("범위를 벗어났습니다.");
                break;
            }

            if (x > 0 && y > 0) {
                System.out.println(1);
            } else if (x < 0 && y > 0) {
                System.out.println(2);
            } else if (x < 0 && y < 0) {
                System.out.println(3);
            } else {
                System.out.println(4);
            }
        }
        sc.close();
    }
}
