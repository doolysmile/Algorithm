package git.Algorithm.programmers.lv2;

import java.util.*;
public class Tuple {
    public int[] solution(String s) {
        int[] answer = {};
        String[] temp  = s.replaceAll("[{}]", "").split("[,]");
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < temp.length ; i++){
            map.put(temp[i], map.getOrDefault(temp[i], 0) + 1);
        }
        ArrayList<String> ans = new ArrayList<>(map.keySet());
        Collections.sort(ans, (o1,o2) ->(map.get(o2).compareTo(map.get(o1))));
        answer = ans.stream().mapToInt(Integer::parseInt).toArray();
        return answer;
    }

    public static void main(String[] args) {
        Tuple t = new Tuple();
        System.out.println(t.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
    }
//    public int[] solution(String s) {
//        int[] answer;
//        String[] num;
//        HashMap<String, Integer> res = new HashMap<>();
//        s = s.replace("{", "");
//        s = s.replace("}", "");
//        num = s.split(",");
//        for(String temp : num){
//            if(res.containsKey(temp)){
//                res.put(temp, res.get(temp)+1);
//            }
//            else {
//                res.put(temp, 1);
//            }
//        }
//        answer = new int[res.size()];
//        // check 1
//        for(Map.Entry<String, Integer> entry : res.entrySet()){
//            answer[res.size() - entry.getValue()] = Integer.parseInt(entry.getKey());
//        }
//        return answer;
//    }
//
//    // 다른 사람 풀이
//    public int[] solution2(String s) {
//        Set<String> set = new HashSet<>();
//        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
//        // check 2
//        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
//        int[] answer = new int[arr.length];
//        int idx = 0;
//        for(String s1 : arr) {
//            for(String s2 : s1.split(",")) {
//                // check 3
//                if(set.add(s2))
//                    answer[idx++] = Integer.parseInt(s2);
//            }
//        }
//        return answer;
//    }
}
