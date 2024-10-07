import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Student[] students;
    static int[][] matrix;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = n * n;
        StringTokenizer st;

        students = new Student[m];
        matrix = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Student student = new Student(Integer.parseInt(st.nextToken()));
            for (int j = 0; j < 4; j++) {
                student.set.add(Integer.parseInt(st.nextToken()));
            }
            students[i] = student;
        }

        for (Student student : students) {
            // 1번 조건 확인
            List<int[]> pos = one(student);

            if (pos.size() == 1) {
                int[] first = pos.get(0);
                matrix[first[0]][first[1]] = student.num;
            } else {
                // 2번 조건 확인
                List<int[]> pos2 = two(pos);

                if (!pos2.isEmpty()) {
                    int[] first = pos2.get(0);
                    matrix[first[0]][first[1]] = student.num;
                }
            }
        }

        int answer = 0;
        for (Student student : students) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (student.num == matrix[i][j]) {
                        int cnt = 0;

                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if (isPossible(nx, ny)) {
                                if (student.set.contains(matrix[nx][ny])) {
                                    cnt++;
                                }
                            }
                        }

                        if (cnt == 1) {
                            answer += 1;
                        } else if (cnt == 2) {
                            answer += 10;
                        } else if (cnt == 3) {
                            answer += 100;
                        } else if (cnt == 4) {
                            answer += 1000;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static List<int[]> two(List<int[]> list) {
        // 인접한 칸 중 비어있는 칸이 몇개인지 센다.
        List<int[]> result = new ArrayList<>();
        int[][] temp = new int[n][n];
        int maxCnt = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(temp[i], -1);
        }

        for (int[] node : list) {
            int cnt = 0;

            for (int k = 0; k < 4; k++) {
                int nx = node[0] + dx[k];
                int ny = node[1] + dy[k];

                if (isPossible(nx, ny)) {
                    if (matrix[nx][ny] == 0) {
                        cnt++;
                    }
                }
            }

            temp[node[0]][node[1]] = cnt;
            maxCnt = Math.max(maxCnt, cnt);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == maxCnt) {
                    result.add(new int[] {i, j});
                }
            }
        }

        return result;
    }

    static List<int[]> one(Student student) {
        // 비어있는 칸의 인접 칸을 확인하고 좋아하는 학생이 있으면 카운트를 센다.
        // 가장 많은 카운트의 위치를 반환한다.
        List<int[]> result = new ArrayList<>();
        int[][] temp = new int[n][n];
        int maxCnt = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(temp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int cnt = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (isPossible(nx, ny)) {
                            if (student.set.contains(matrix[nx][ny])) {
                                cnt++;
                            }
                        }
                    }

                    temp[i][j] = cnt;
                    maxCnt = Math.max(maxCnt, cnt);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == maxCnt) {
                    result.add(new int[] {i, j});
                }
            }
        }

        return result;
    }

    static boolean isPossible(int nx, int ny) {
        if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) {
            return false;
        }
        return true;
    }

    static class Student {
        int num;
        Set<Integer> set = new HashSet<>();

        public Student(int num) {
            this.num = num;
        }
    }
}
