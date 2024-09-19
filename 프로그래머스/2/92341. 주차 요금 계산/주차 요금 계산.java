import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Car> map = new TreeMap<>();
        
        for (String record : records) {
            String[] item = record.split(" ");
            String[] timeStr = item[0].split(":");
            String name = item[1];
            String status = item[2];
            int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);
            
            if (map.containsKey(name)) {
                Car car = map.get(name);
                
                if (status.equals("IN") && car.status.isEmpty()) {
                    car.status = status;
                    car.time = time;
                } else if (status.equals("OUT") && car.status.equals("IN")) {
                    car.parkingTime += time - car.time;
                    car.status = "";
                    car.time = 0;
                }
            } else {
                map.put(name, new Car(time, status));
            }
        }
        
        answer = new int[map.values().size()];
        int idx = 0;
        for (Car car : map.values()) {
            if (car.status.equals("IN")) {
                int time = 23 * 60 + 59;
                car.parkingTime += time - car.time;
            }
            
            int pay = 0;
            if (car.parkingTime > fees[0]) {
                int val = (car.parkingTime - fees[0]) / fees[2];
                int rest = (car.parkingTime - fees[0]) % fees[2];
                if (rest > 0) {
                    val++;
                }
                
                pay = val * fees[3];
            }
            
            answer[idx++] = fees[1] + pay;
        }
        
        return answer;
    }
    
    static class Car {
        int time;
        String status;
        int parkingTime;
        
        public Car(int time, String status) {
            this.time = time;
            this.status = status;
        }
    }
}