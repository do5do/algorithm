import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 국가 수
        int k = Integer.parseInt(st.nextToken()); // 알고싶은 국가

        List<Nation> nations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            nations.add(new Nation(number, gold, silver, bronze));
        }

        Collections.sort(nations);
        nations.get(0).rank = 1;
        int target = 0;

        // 동점 판별
        for (int i = 1; i < n; i++) {
            if (nations.get(i - 1).gold == nations.get(i).gold &&
                    nations.get(i - 1).silver == nations.get(i).silver &&
                    nations.get(i - 1).bronze == nations.get(i).bronze) { // 공동
                nations.get(i).rank = nations.get(i - 1).rank;
            } else {
                nations.get(i).rank = i + 1;
            }

            if (nations.get(i).number == k) {
                target = i;
            }
        }

        System.out.println(nations.get(target).rank);
    }

    static class Nation implements Comparable<Nation> {
        int number;
        int gold;
        int silver;
        int bronze;
        int rank = 0;

        public Nation(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            int result = Integer.compare(o.gold, gold);
            if (result == 0) {
                result = Integer.compare(o.silver, silver);
                if (result == 0) {
                    result = Integer.compare(o.bronze, bronze);
                }
            }
            return result;
        }
    }
}