package programers.naverf;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        int answer = 0;
        String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
        int k = 3;
        HashMap<String, Integer> hm = new HashMap<>();

        for (String ids : id_list) {
            String[] id = ids.split(" "); // 각 날의 인원
            HashSet<String> hs = new HashSet<>();

            for (int i = 0; i < id.length; i++) {
                hs.add(id[i]);
            }

            for (String h : hs) {
                hm.put(h, hm.getOrDefault(h, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (hm.get(entry.getKey()) > k) {
                answer += k;
            } else {
                answer += hm.get(entry.getKey());
            }
        }

        System.out.println(hm);
        System.out.println(answer);
    }
}
