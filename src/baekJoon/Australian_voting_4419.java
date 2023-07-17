package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Australian_voting_4419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 후보자 수
        List<String> candidates = new ArrayList<>(); // 후보자
        Map<String, Integer> mappedCandidates = new HashMap<>(); // 후보자 이름, 투표수
        int[][] votes = new int[1000][n]; // 투표 내역
        int voterNum = 0; // 유권자 수

        for (int i = 0; i < n; i++) {
            mappedCandidates.put(br.readLine(), 0);
            candidates.add(br.readLine());
        }

        // set 투표 내역
        StringTokenizer st;
        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            for (int i = 0; i < n; i++) {
                votes[voterNum][i] = Integer.parseInt(st.nextToken());
            }
            voterNum++;
        }

        // 득표수 세기
        for (int i = 0; i < voterNum; i++) {
            String name = candidates.get(votes[i][0]);
            mappedCandidates.put(name, mappedCandidates.get(name) + 1);
        }

        while (true) {

        }
    }
}
