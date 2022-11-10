package git.Algorithm.programmers.lv2;

import java.util.*;

public class Solution92341 {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> ans = new TreeMap<>();
        // 차량 번호, 입차 시간
        Map<String, String> parkingLot = new HashMap<>();
        for(String record : records){
            String[] tmp = record.split(" ");
            if(tmp[2].equals("IN")){
                parkingLot.put(tmp[1], tmp[0]);
            }
            else{
                int time = calTime(parkingLot.get(tmp[1]), tmp[0]);
                parkingLot.remove(tmp[1]);
                ans.put(tmp[1], ans.getOrDefault(tmp[1], 0) + time);
            }
        }
        for(Map.Entry<String, String> entry : parkingLot.entrySet()){
            int time = calTime(entry.getValue(), "23:59");
            ans.put(entry.getKey(), ans.getOrDefault(entry.getKey(), 0) + time);
        }
        for(Map.Entry<String, Integer> entry : ans.entrySet()){
            answer.add(calPrice(entry.getValue(), fees));
        }
        return Arrays.stream(answer.toArray(Integer[]::new)).mapToInt(Integer::intValue).toArray();
    }
    static int calPrice(int time, int[] fees){
        int price = fees[1];
        if(time <= fees[0]){
            return price;
        }
        else{
            time -= fees[0];
            if(time % fees[2] > 0){
                time = time/fees[2] + 1;
            }
            else{
                time = time/fees[2];
            }
            price = price + time*fees[3];
        }
        return price;
    }
    static int calTime(String s, String e){
        int[] start = Arrays.stream(s.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(e.split(":")).mapToInt(Integer::parseInt).toArray();
        int ans = end[0]*60 + end[1] - start[0]*60 - start[1];
        return ans;
    }
    public static void main(String[] args) {
        Solution92341 s = new Solution92341();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(s.solution(fees, records));
    }
}
