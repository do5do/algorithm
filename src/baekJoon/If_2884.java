package baekJoon;

import java.util.Scanner;

public class If_2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();
        String[] times =  time.split(" ");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);

        // 분 setting
        if (minute < 45) {
            hour -= 1;
            minute = minute + 60;
            if (hour < 0) {
                hour = 23;
            }
            System.out.println(hour+" "+(minute - 45));
        } else {
            System.out.println(hour+" "+(minute - 45));
        }

        sc.close();
    }
}
