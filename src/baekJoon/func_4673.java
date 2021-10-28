package baekJoon;

import java.util.HashSet;

public class func_4673 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 1; i <= 10000; i++) {
            hs.add(i); // 1~10000 전체 숫자 세팅
        }
        for (int i = 1; i <= 10000; i++) {
            int n = d(i); // 생성자
            hs.remove(n); // 전체 숫자가 담긴 곳에서 생성자를 제거 => 셀프 넘버
        }
        for (int h : hs) { // 출력
            System.out.println(h);
        }
        //System.out.println(hs);
    }

    public static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum = sum + (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
