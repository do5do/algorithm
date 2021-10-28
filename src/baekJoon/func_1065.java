package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class func_1065 { // 어떤 정수 X의 자릿수가 등차수열을 이루는지? -> 1~N개의 수 중 앞의 조건을 만족하는 등차수열은 몇개인지 구하는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(math(N));
    }

    static int math(int N) {
        int cnt;
        if (N <= 99) { // 1~99는 모두 등차수열
            cnt = N;
        } else { // 100부터 각자리 수 비교
            cnt = 99;
            if (N == 1000) N = 999; // 1000일 경우 999와 결과가 같음

            for (int i = 100; i <= N; i++) {
                int hun = i / 100;
                int ten = (i/10) % 10;
                int one = i % 10;
                if (hun - ten == ten - one) cnt++; // 등차수열을 이루는게 몇개인지 카운트
            }
        }
        return cnt;
    }
}
