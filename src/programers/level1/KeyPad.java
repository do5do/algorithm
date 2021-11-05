package programers.level1;

public class KeyPad {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String answer = "";

        StringBuffer sb = new StringBuffer(answer);
        int[][] keyPad = new int[4][3];
        int L = -1; // *
        int R = -1; // #
        int k = 1;
        int ni = 0;
        int ri = 0;
        int li = 0;
        int nj = 0;
        int rj = 0;
        int lj = 0;

        for (int i = 0; i < keyPad.length; i++) { // 좌표 setting
            for (int j = 0; j < keyPad[i].length; j++) {
                if (i == 3) {
                    keyPad[3][0] = -1;
                    keyPad[3][1] = 0;
                    keyPad[3][2] = -1;
                } else {
                    keyPad[i][j] = k++;
                }
                System.out.println(i+","+j+" : "+keyPad[i][j]);
            }
        }

        for (int number : numbers) {
            if (number == 1 | number == 4 | number == 7) {
                sb.append("L");
                L = number;
            } else if (number == 3 | number == 6 | number == 9) {
                sb.append("R");
                R = number;
            } else { // 2, 5, 8, 0
                for (int i = 0; i < keyPad.length; i++) {
                    for (int j = 0; j < keyPad[i].length; j++) {
                        if (keyPad[i][j] == number) {
                            ni = i;
                            nj = j;
                        }
                        if (keyPad[i][j] == L) {
                            li = i;
                            lj = j;
                        }
                        if (keyPad[i][j] == R) {
                            ri = i;
                            rj = j;
                        }
                    }
                }

                if (Math.abs(ni - li) + Math.abs(nj - lj) > Math.abs(ni - ri) + Math.abs(nj - rj)) {
                    sb.append("R");
                    R = number;
                } else if (Math.abs(ni - li) + Math.abs(nj - lj) < Math.abs(ni - ri) + Math.abs(nj - rj)) {
                    sb.append("L");
                    L = number;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        R = number;
                    } else {
                        sb.append("L");
                        L = number;
                    }
                }
            }
        }

        answer = sb.toString();
        System.out.println(answer);
    }
}
