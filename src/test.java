import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        int solution = solution(1.42);
        System.out.println(solution);

        int solution2 = solution(69.32);
        System.out.println(solution2);


        Queue<Integer>[] queue = new LinkedList[10001];
        for (int i = 0; i < 3; i++) {
            queue[0] = new LinkedList<>();
        }
    }

    public static int solution(double flo) {
//        return (Integer.parseInt(Double.toString(flo).split("\\.")[0]));
//        return (int) flo;
        return (int) Math.round(flo);
    }
}
