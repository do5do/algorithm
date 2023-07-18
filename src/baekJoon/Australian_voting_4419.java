package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Australian_voting_4419 {
    static List<String> candidates = new ArrayList<>(); // 후보자
    static List<List<Integer>> votes = new ArrayList<>(); // 투표 내역
    static List<String> electedCandidates = new ArrayList<>(); // 선출된 후보자 (return value)
    static int numCandidates;
    static int numVotes; // 유권자 수 (투표 용지 수)
    static int[] votedCandidates; // 후보자별 득표수
    static boolean[] eliminatedCandidates; // 탈락 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 후보자 수

        for (int i = 0; i < n; i++) { // 후보자 세팅
            candidates.add(br.readLine());
        }

        // 투표 내역 세팅
        StringTokenizer st;
        String input;
        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }

            st = new StringTokenizer(input);
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()) - 1); // 후보자 index 맞춰주기 위해 -1을 해준다.
            }
            votes.add(arr);
        }

        // 개표
        vote(candidates, votes);
        for (String candidate : electedCandidates) {
            System.out.println(candidate); // 출력
        }
    }

    public static void vote(List<String> candidates, List<List<Integer>> votes) {
        numCandidates = candidates.size();
        numVotes = votes.size();
        votedCandidates = new int[numCandidates];
        eliminatedCandidates = new boolean[numCandidates];

        // 첫 개표
        for (List<Integer> vote : votes) {
            votedCandidates[vote.get(0)]++; // 득표수 올리기
        }

        while (!getVote()) { // 과반수를 넘은 후보가 있거나 모두 동률이면 중단
            // 최소 득표수 갱신
            int minVote = Integer.MAX_VALUE;
            for (int i = 0; i < numCandidates; i++) {
                if (!eliminatedCandidates[i] && votedCandidates[i] < minVote) {
                    minVote = votedCandidates[i];
                }
            }

            // 과반수를 넘은 후보가 없을 때 최소 득표를 한 후보 탈락
            for (int i = 0; i < numCandidates; i++) {
                if (!eliminatedCandidates[i] && votedCandidates[i] == minVote) {
                    eliminatedCandidates[i] = true;
                }
            }

            // 재집계
            votedCandidates = new int[numCandidates]; // 득표수 초기화
            for (List<Integer> vote : votes) {
                votedCandidates[vote.get(0)]++; // 득표수 올리기
            }
        }
    }

    public static boolean getVote() {
        boolean flag = true;

        for (int i = 0; i < numCandidates; i++) {
            if (!eliminatedCandidates[i]) {
                int num = votedCandidates[0];

                if (votedCandidates[i] > numVotes / 2) { // 과반수를 넘은 후보가 있는지 확인
                    electedCandidates.add(candidates.get(i));
                    flag = true;
                }

                if (votedCandidates[i] != num) { // 남은 후보가 모두 동률인지 확인
                    flag = false;
                }
            }
        }

        return flag;
    }
}
