package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int num = 9;
        for(int i = 0; i <N; i++){
            String[] temp = br.readLine().split("");
            int mul = 1;
            for(int j = temp.length - 1; j >= 0; j--){
                map.put(temp[j], map.getOrDefault(temp[j], 0) + mul);
                mul *= 10;
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(Map.Entry<String, Integer> entry : entryList){
            ans += entry.getValue() * num;
            num--;
        }
        System.out.println(ans);
    }
}
