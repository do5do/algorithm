package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class For_10871 {
    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int x = Integer.parseInt(br.readLine()); // 비교하는 숫자

        // 랜덤 숫자 겹치는거 없이 뽑기
//        for (int i = 0; i < a.length; i++) {
//            a[i] = (int) (Math.random() * 20) + 1;
//            for (int j = i+1; j < a.length; j++) {
//                if (a[i] == a[j]) {
//                    i--;
//                    break;
//                }
//            }
//        }
        // 배열확인
//        for (int a2 : a) {
//            System.out.print(a2+" ");
//        }
//        System.out.println();

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] < x) {
                System.out.print(a[i]+" ");
            }
        }
        System.out.println();
        br.close();

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        System.out.println("시간차이(m) : "+(afterTime - beforeTime));
    }
}
