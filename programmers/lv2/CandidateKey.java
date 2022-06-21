package git.Algorithm.programmers.lv2;

import java.util.*;

public class CandidateKey {
    public int solution(String[][] relation) {
        Queue<String> queue = new LinkedList<>();
        List<String> keySet = new ArrayList<>();
        int column = relation[0].length;
        int row = relation.length;
        // 초기 column값 넣는 부분
        for(int i = 0; i < column; i++){
            queue.add(i+"");
        }

        while(!queue.isEmpty()){
            HashSet<String> setTmp = new HashSet<>();
            String keyRaw = queue.poll();
            String keys[] = keyRaw.split("");


            for(int i = 0 ; i < row; i++){
                String value = "";
                for(String key : keys){
                    int columnTmp = Integer.parseInt(key);
                    value = value + relation[i][columnTmp] + " ";
                }
                setTmp.add(value);
            }
            if(setTmp.size() == row){
                boolean check = true;
                for(int j = 0 ; j < keySet.size(); j++){
                    String[] cmpKey = keySet.get(j).split("");
                    String match = "(.*)"+ String.join("(.*)", cmpKey)+ "(.*)";
                    if(keyRaw.matches(match)){
                        check = false;
                        break;
                    }
                }
                if(check == true){
                    keySet.add(keyRaw);
                }

            }
            else{
                int lastKey = Integer.parseInt(keys[keys.length-1]);
                for(int i = lastKey + 1; i < column; i++){
                    String t = keyRaw + i;
                    queue.add(t);
                }
            }
        }

        return keySet.size();
    }
}

