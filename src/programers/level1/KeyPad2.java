package programers.level1;

public class KeyPad2 {
    private int[][] keyPad() { // 좌표 setting
        int[][] keyPad = new int[10][2];
        keyPad[0][0] = 3;
        keyPad[0][1] = 1;
        int i = 1;
        int k = 0;

        while (i < 10) {
            for (int j = 0; j < 3; j++) {
                keyPad[i][0] = k;
                keyPad[i][1] = j;
                i++;
            }
            k++;
        }
//        for (int[] idx : keyPad) { // 확인
//            System.out.print(idx[0] + ", " + idx[1]);
//            System.out.println();
//        }
        return keyPad;
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";

        StringBuffer sb = new StringBuffer(answer);
        int leftHand = 10;
        int rightHand = 12;
        int leftDistance = 0;
        int rightDistance = 0;

        for (int number : numbers) {
            if (number == 1 | number == 4 | number == 7) {
                sb.append("L");
                leftHand = number;
            } else if (number == 3 | number == 6 | number == 9) {
                sb.append("R");
                rightHand = number;
            } else {
                leftDistance = distance(number, leftHand);
                rightDistance = distance(number, rightHand);

                if (leftDistance > rightDistance) {
                    sb.append("R");
                    rightHand = number;
                } else if (leftDistance == rightDistance) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightHand = number;
                    } else {
                        sb.append("L");
                        leftHand = number;
                    }
                } else {
                    sb.append("L");
                    leftHand = number;
                }
            }
        }

        answer = sb.toString();
        return answer;
    }

    private int distance(int number, int hand) { // 거리 구하기
        int handX, handY;
        if (hand == 10) {
            handX = 3;
            handY = 0;
        } else if (hand == 12) {
            handX = 3;
            handY = 2;
        } else {
            handX = keyPad()[hand][0];
            handY = keyPad()[hand][1];
        }
        int numX = keyPad()[number][0];
        int numY = keyPad()[number][1];

        return Math.abs(numX - handX) + Math.abs(numY - handY); // abs() : 절대값 출력 (음수면 -떼기)
    }

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "right";

        KeyPad2 key = new KeyPad2();
        System.out.println(key.solution(numbers, hand));
    }
}