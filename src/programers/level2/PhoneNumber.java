package programers.level2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class PhoneNumber {
    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789"};
//        String[] phone_book = {"12","123","1235","567","88"};
//        String[] phone_book = {"1195524421", "97674223", "119"};
//        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123", "456", "789", "4567"};
        boolean answer = true;

        HashSet<String> hs = new HashSet<>();
        Collections.addAll(hs, phone_book); // 한번에 담기

        for (String h : hs) {
            for (int i = 1; i < h.length(); i++) {
                if (hs.contains(h.substring(0,i))) {
                    answer = false;
                    break;
                }
            }
        }

        // 효용성 0점
//        for (int i = 0; i < phone_book.length; i++) {
//            for (int j = phone_book.length - 1; j >= 0; j--) {
//                if (!phone_book[j].equals(phone_book[i]) && phone_book[j].startsWith(phone_book[i])) {
//                    answer = false;
//                    break;
//                }
//            }
//        }

//        System.out.println(hs);
        System.out.println(answer);
    }
}
