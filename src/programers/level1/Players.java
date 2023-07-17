package programers.level1;

import java.util.*;

public class Players {
    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> mappedPlayers = new HashMap<>();
        Map<Integer, String> mappedRank = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            mappedPlayers.put(players[i], i);
            mappedRank.put(i, players[i]);
        }

        for (String call : callings) {
            int callRank = mappedPlayers.get(call); // 불려진 선수 순위
            String beforePlayer = mappedRank.get(callRank - 1); // 불려진 선수 앞 선수 이름

            mappedRank.put(callRank, beforePlayer); // 불려진 선수 앞 순위인 사람 뒤로 한칸 이동 -> 불려진 선수 순위로 스왑
            mappedRank.put(callRank - 1, call); // 불려진 선수 순위 앞으로 한칸 이동

            // players도 수정
            mappedPlayers.put(beforePlayer, callRank);
            mappedPlayers.put(call, callRank - 1);
        }

        System.out.println("mappedRank = " + mappedRank);
        System.out.println("mappedPlayers = " + mappedPlayers);

        return mappedRank.values().toArray(new String[players.length]);
    }

    public static void main(String[] args) {
        String[] result = solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        System.out.println(Arrays.toString(result));
    }
}
