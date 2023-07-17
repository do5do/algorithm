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
        List<int[]> votes = new ArrayList<>(); // 투표 내역

        for (int i = 0; i < n; i++) {
            mappedCandidates.put(br.readLine(), 0);
            candidates.add(br.readLine());
        }

        // 투표 내역 세팅
        StringTokenizer st;
        String input;
        while ((input = br.readLine()) != null && input.length() > 0) {
            st = new StringTokenizer(input);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1; // index 맞춰주기 위해 -1을 해준다.
            }
            votes.add(arr);
        }

        // 득표수 세기
        for (int[] vote : votes) {
            String name = candidates.get(vote[0]);
            mappedCandidates.put(name, mappedCandidates.get(name) + 1);
        }

        System.out.println(mappedCandidates);

//        while (true) {
//
//        }
    }
}
