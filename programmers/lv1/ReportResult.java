package git.Algorithm.programmers.lv1;

import java.util.*;

public class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] ret = new int[id_list.length];
        Map<String, Integer> index = new HashMap<>();
        Map<String, List<Integer>> list = new HashMap<>();

        for(int i=0 ; i<id_list.length ; i++) {
            index.put(id_list[i],i);
        }

        for(String rep : report) {
            String[] ids = rep.split(" ");
            String fromId=ids[0], toId=ids[1];
            if(!list.containsKey(toId))
                list.put(toId, new ArrayList<>());
            List<Integer> tmp = list.get(toId);
            if(!tmp.contains(index.get(fromId)))
                tmp.add(index.get(fromId));
        }

        for(int i=0 ; i<id_list.length ; i++) {
            String id = id_list[i];
            if(list.containsKey(id) && list.get(id).size()>=k) {
                for(int idx : list.get(id)) {
                    ret[idx]++;
                }
            }
        }

        return ret;
    }

/**
 * 처음에 구조를 잘못 정해서 마지막 for문에서 힘들어짐,
 * id를 숫자로 변환시켜 index를 찾는 쪽으로 짜야함
 */
//    public int[] solution(String[] id_list, String[] report, int k) {
//        int[] answer = new int[id_list.length];
//        HashMap<String, List<String>> repResult = new HashMap<>();
//        HashMap<String, Integer> result = new HashMap<>();
//        for(String tmp : id_list){
//            result.put(tmp, 0);
//        }
//        for(String r : report){
//            String [] check = r.split(" ");
//            if(!repResult.containsKey(check[1])){
//                repResult.put(check[1], new ArrayList<>());
//            }
//            List<String> tmp = repResult.get(check[1]);
//            if(!tmp.contains(check[0])){
//                tmp.add(check[0]);
//            }
//        }
//        System.out.println("repResult = " + repResult.toString());
//        for(int i = 0; i < id_list.length; i++){
//            String id = id_list[i];
//            if(repResult.containsKey(id) && repResult.get(id).size() >= k){
//                String tmp[] = repResult.get(id).toArray(new String[repResult.get(id).size()]);
//                for(String t : tmp){
//                    result.
//                }
//            }
//        }
//        return answer;
//    }
}
