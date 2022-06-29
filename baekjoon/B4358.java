package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String tree;
        int totalNum = 0;
        Object[] keys;
        Map<String, Integer> map = new HashMap<>();
        tree = br.readLine();
        while(true){
            map.put(tree, map.getOrDefault(tree,0) + 1);
            totalNum++;
            tree = br.readLine();
            if(tree == null || tree.length() == 0 ||tree.equals("\n")){
                break;
            }
        }
        keys =  map.keySet().toArray();
        Arrays.sort(keys);
        for(Object key : keys){
            String tmp = (String) key;
            double rate = (double) map.get(key)*100 / totalNum;
            sb.append(tmp + " " + String.format("%.4f", rate) + "\n");
        }
        System.out.println(sb.toString());
    }
}
