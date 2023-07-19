package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Australian_voting_4419 {
    static String[] candidates; // 후보자
    static List<Queue<Integer>> votes = new ArrayList<>(); // 투표 내역
    static int numCandidates; // 후보자 수
    static int numVotes; // 유권자 수
    static int[] votedCandidates; // 후보자 별 득표 수
    static boolean[] eliminatedCandidates; // 후보자 탈락 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 후보자 수

        // 초기화
        candidates = new String[n];
        votedCandidates = new int[numCandidates];
        eliminatedCandidates = new boolean[numCandidates];

        // 후보자 세팅
        for (int i = 0; i < n; i++) {
            candidates[i] = br.readLine();
        }

        // 투표 내역 세팅
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);
            Queue<Integer> vote = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                vote.offer(Integer.parseInt(st.nextToken()) - 1); // 후보자 index 맞춰주기 위해 -1을 해준다.
            }
            votes.add(vote);
        }
        numVotes = votes.size();

        // 유권자가 없을 때
        if (numVotes == 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(candidates[i]);
            }
        }

        // 후보자 선출
        numCandidates = candidates.length;
        getElectedCandidates();
    }

    public static void getElectedCandidates() {
        // 첫 개표
        getVote();

        // 과반수를 넘은 후보가 있으면 중단
        while (!checkMajority()) {
            // 최소 득표수 갱신
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < numCandidates; i++) {
                if (!eliminatedCandidates[i]) {
                    min = Math.min(min, votedCandidates[i]);
                }
            }

            // 동률 확인
            boolean tie = true;
            for (int i = 0; i < numCandidates; i++) {
                if (!eliminatedCandidates[i] && votedCandidates[i] != min) { // 모든 득표수가 최소값과 같으면 모두 동률
                    tie = false;
                    break;
                }
            }

            // 동률이면 중단
            if (tie) {
                for (int i = 0; i < numCandidates; i++) {
                    if (!eliminatedCandidates[i]) {
                        System.out.println(candidates[i]);
                    }
                }
                break;
            }

            // 과반수를 넘은 후보가 없을 때 최소 득표를 한 후보 탈락
            for (int i = 0; i < numCandidates; i++) {
                if (!eliminatedCandidates[i] && votedCandidates[i] == min) {
                    eliminatedCandidates[i] = true;
                }
            }

            // 탈락한 후보 투표 내역에서 제거
            for (Queue<Integer> vote : votes) {
                if (!vote.isEmpty() && eliminatedCandidates[vote.peek()]) {
                    vote.poll();
                }
            }

            // 재집계
            votedCandidates = new int[numCandidates]; // 득표수 초기화
            getVote();
        }
    }

    private static void getVote() { // 개표
        for (Queue<Integer> vote : votes) {
            if (!vote.isEmpty()) {
                votedCandidates[vote.peek()]++; // 득표수 카운트
            }
        }
    }

    public static boolean checkMajority() { // 과반수 확인
        for (int i = 0; i < numCandidates; i++) {
            if (!eliminatedCandidates[i]) {
                if (votedCandidates[i] > numVotes / 2) { // 과반수를 넘은 후보가 있는지 확인
                    System.out.println(candidates[i]);
                    return true;
                }
            }
        }
        return false;
    }
}