package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> poketmon1 = new HashMap<>();
        HashMap<Integer, String> poketmon2 = new HashMap<>();
        for(int i = 1; i <= N; i++){
            String temp = br.readLine();
            poketmon1.put(temp, i);
            poketmon2.put(i, temp);
        }
        for(int i = 0; i < M; i++){
            String temp = br.readLine();
            if(poketmon1.containsKey(temp)){
                sb.append(poketmon1.get(temp) + "\n");
            }
            else{
                sb.append(poketmon2.get(Integer.parseInt(temp)) + "\n");
            }
        }
        System.out.print(sb.toString());
    }
}
