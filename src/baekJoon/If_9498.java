package baekJoon;

public class If_9498 {
    public static void main(String[] args) {
        int score = (int) (Math.random() * 100) + 1;
        int num = score / 10;
        System.out.println("score : "+score);

        if (num >= 9) {
            System.out.println("A");
        } else if (num == 8) {
            System.out.println("B");
        } else if (num == 7) {
            System.out.println("C");
        } else if (num == 6) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
