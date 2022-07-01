package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeMap<Integer, TreeSet> level = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            if(level.get(L) == null){
                TreeSet<Integer> tmp = new TreeSet<>();
                tmp.add(P);
                level.put(L, tmp);
            }
            else{
                TreeSet tmp = level.get(L);
                tmp.add(P);
                level.put(L, tmp);
            }
        }
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("add")){
                int P = Integer.parseInt(s[1]);
                int L = Integer.parseInt(s[2]);
                if(level.get(L) == null){
                    TreeSet<Integer> tmp = new TreeSet<>();
                    tmp.add(P);
                    level.put(L, tmp);
                }
                else{
                    TreeSet tmp = level.get(L);
                    tmp.add(P);
                    level.put(L, tmp);
                }
            }
            else if(s[0].equals("solved")){
                Set<Integer> keySet = level.keySet();
                Iterator iter = keySet.iterator();
                while(iter.hasNext()) {
                    int key = (int) iter.next();
                    TreeSet<Integer> tmp = level.get(key);
                    if(tmp.contains(Integer.parseInt(s[1]))){
                        tmp.remove(Integer.parseInt(s[1]));
                        if(tmp.size() == 0){
                            level.remove(key);
                        }
                        else{
                            level.put(key, tmp);
                        }

                        break;
                    }
                }
            }
            else if(s[0].equals("recommend")){
                int a = Integer.parseInt(s[1]);
                if(a == 1){
                    TreeSet<Integer> tmp = level.lastEntry().getValue();
                    int L = level.lastKey();
                    sb.append(tmp.last() + "\n");
                    level.put(L, tmp);
                }
                else{
                    TreeSet<Integer> tmp = level.firstEntry().getValue();
                    int L = level.firstKey();
                    sb.append(tmp.first() + "\n");
                    level.put(L, tmp);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
