package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Array_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine()); // test case
        StringTokenizer st;
        int[][] student = new int[C][];
        int[] sum = new int[C];

        for (int i = 0; i < C; i++) { // 입력
            st = new StringTokenizer(br.readLine(), " "); // 학생수, 점수 입력
            int num = Integer.parseInt(st.nextToken()); // 학생수 set
            student[i] = new int[num]; // 학생 배열 생성
            for (int j = 0; j < num; j++) {
                student[i][j] = Integer.parseInt(st.nextToken());
                sum[i] += student[i][j];
            }
        }

        for (int i = 0; i < student.length; i++) { // 출력
            int cnt = 0;
            float result;
            for (int j = 0; j < student[i].length; j++) {
                if (student[i][j] > sum[i] / student[i].length) { // 평균보다 높은 학생 수
                    cnt++;
                }
            }
            result = ((float) 100 / student[i].length) * cnt;
            System.out.println(String.format("%.3f", result)+"%");
        }
        //System.out.println(Arrays.deepToString(student));
    }
}
