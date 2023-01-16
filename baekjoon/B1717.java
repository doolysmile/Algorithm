package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            int ele1 = Integer.parseInt(st.nextToken());
            int ele2 = Integer.parseInt(st.nextToken());
            if(mode == 0){
                union(ele1, ele2);
            }
            else{
                if(check(ele1, ele2)){
                    sb.append("YES" + "\n");
                }
                else{
                    sb.append("NO" + "\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
    static int findParent(int x){
        if(x == parent[x]){
            return parent[x];
        }
        else {
            return parent[x] = findParent(parent[x]);
        }
    }
    static void union(int ele1, int ele2){
        int ele1Parent = findParent(ele1);
        int ele2Parent = findParent(ele2);
        if(ele1Parent != ele2Parent){
            if(ele1Parent < ele2Parent){
                parent[ele2Parent] = ele1Parent;
            }
            else{
                parent[ele1Parent] = ele2Parent;
            }
        }
    }
    static boolean check(int ele1, int ele2){
        int ele1Parent = findParent(ele1);
        int ele2Parent = findParent(ele2);
        if(ele1Parent != ele2Parent){
            return false;
        }
        else{
            return true;
        }
    }
}
