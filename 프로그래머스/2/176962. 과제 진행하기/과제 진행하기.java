import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        List<Task> tasks = new ArrayList<>();
        
        for (String[] plan : plans) {
            String[] startArr = plan[1].split(":");
            int start = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
            int time = Integer.parseInt(plan[2]);
            tasks.add(new Task(plan[0], start, time));
        }
        
        Collections.sort(tasks);
        
        Stack<Task> stack = new Stack<>(); // 멈춘 과제
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < tasks.size(); i++) {
            Task curTask = tasks.get(i);
            
            if (i < tasks.size() - 1) {
                Task nextTask = tasks.get(i + 1);
                
                if (curTask.start + curTask.time < nextTask.start) { // 다음 과제를 바로 진행할 수 없는 경우
                    result.add(curTask.name); // 현재 과제 완료
                    int now = curTask.start + curTask.time;
                    
                    while (!stack.isEmpty()) { // 멈춰둔 과제 확인
                        Task stoppedTask = stack.peek();
                        
                        if (now + stoppedTask.time <= nextTask.start) { // 다음 과제 시작 전까지 다 끝낼 수 있는 경우
                            stack.pop();
                            result.add(stoppedTask.name);
                            now += stoppedTask.time;
                        } else { // 할 수 있는 만큼 진행
                            stoppedTask.time -= nextTask.start - now;
                            break;
                        }
                    }
                } else if (curTask.start + curTask.time == nextTask.start) {
                    result.add(curTask.name);
                } else { // 현재 과제 멈춤
                    int doingTime = nextTask.start - curTask.start;
                    curTask.time -= doingTime;
                    stack.push(curTask);
                }
            } else { // 마지막 과제
                result.add(curTask.name);
                
                while (!stack.isEmpty()) {
                    result.add(stack.pop().name);
                }
            }
        }
        
        answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    static class Task implements Comparable<Task> {
        String name;
        int start;
        int time;
        
        public Task(String name, int start, int time) {
            this.name = name;
            this.start = start;
            this.time = time;
        }
        
        public int compareTo(Task o) {
            return Integer.compare(start, o.start);
        }
    }
}