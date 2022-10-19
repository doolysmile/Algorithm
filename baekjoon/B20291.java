package git.Algorithm.baekjoon;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class B20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < N ; i++){
            String[] temp = br.readLine().split("[.]");
            if(map.get(temp[1]) == null) {
                map.put(temp[1], 1);
            }
            else {
                map.put(temp[1], map.get(temp[1])+1);
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()+" "+entry.getValue()+"\n");
        }
        System.out.println(sb.toString());
    }
}
