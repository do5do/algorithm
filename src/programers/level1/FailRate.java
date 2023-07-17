package programers.level1;

import java.util.*;

public class FailRate {
    public static void main(String[] args) {
        int N = 5;
        Integer[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] answer = new int[N];
        Map<Integer, Float> map = new HashMap<>();

        for (int i = 1; i <= N; i++) { // i는 stage
            float stageCnt = 0;
            float totalStage = 0;

            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) {
                    stageCnt++;
                }
                if (i <= stages[j]) {
                    totalStage++;
                }

            }

            if (stageCnt == 0) { // 스테이지에 도달한 사람이 없으면 실패율은 0
                map.put(i, 0.f);
            } else {
                map.put(i, stageCnt / totalStage);
            }
        }
        List<Map.Entry<Integer, Float>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> Float.compare(o2.getValue(), o1.getValue())); // 내림차순 정렬 (o1과 o2의 순서가 바뀌면 오름차순 정렬)

        // 위 정렬을 풀어서 쓰면 이렇게 된다.
//        List<Map.Entry<Integer, Float>> list = new LinkedList<>(map.entrySet());
//        list.sort(new Comparator<Map.Entry<Integer, Float>>() { // 내림차순 정렬
//            @Override
//            public int compare(Map.Entry<Integer, Float> o1, Map.Entry<Integer, Float> o2) {
//                if (o1.getValue() > o2.getValue()) {
//                    return -1;
//                } else if (o1.getValue() == o2.getValue()) {
//                    return 0;
//                } else { // o1.getValue() < o2.getValue()
//                    return 1;
//                }
//            }
//        });
//
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).getKey();
        }

        System.out.println(Arrays.toString(answer));
    }
}
