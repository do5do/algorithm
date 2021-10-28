package baekJoon;

public class func_15596 {
    public static void main(String[] args) {
        int[] a = {10, 20, 30};
        long sum = sum(a);
        System.out.println(sum);
    }
    static long sum(int[] a) {
        long sum = 0;
        for (int a1 : a) {
            sum += a1;
        }
        return sum;
    }
}


