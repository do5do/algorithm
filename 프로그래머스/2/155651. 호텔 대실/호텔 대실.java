import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<Reservation> reservations = new ArrayList<>();
        
        for (String[] book : book_time) {
            String[] startArr = book[0].split(":");
            int start = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
            
            String[] endArr = book[1].split(":");
            int end = Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]);
            
            reservations.add(new Reservation(start, end));
        }
        
        Collections.sort(reservations);
        List<Integer> rooms = new ArrayList<>();
        
        for (int i = 0; i < reservations.size(); i++) {
            Reservation cur = reservations.get(i);
            boolean newRoom = true;
            
            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(j) <= cur.start) {
                    newRoom = false;
                    rooms.set(j, cur.end + 10);
                    break;
                }
            }
            
            if (newRoom) {
                rooms.add(cur.end + 10);
            }
        }
        
        return rooms.size();
    }
    
    static class Reservation implements Comparable<Reservation> {
        int start;
        int end;
        
        public Reservation(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Reservation o) {
            return Integer.compare(this.start, o.start);
        }
    }
}