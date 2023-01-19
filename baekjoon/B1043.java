package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1043 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int trueCnt = Integer.parseInt(st.nextToken());
        int liar[] = new int[trueCnt + 1];
        int ans = 0;
        if(trueCnt == 0){
            System.out.println(M);
            return;
        }
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;

        }

        for(int i = 1; i <= trueCnt; i++){
            liar[i] = Integer.parseInt(st.nextToken());
            if(i != 1){
                union(liar[i - 1], liar[i]);
            }
        }

        int[][] partyInfo = new int[M][];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            partyInfo[i] = new int[people];
            for(int j = 0; j < people; j++){
                partyInfo[i][j] = Integer.parseInt(st.nextToken());
                if(j != 0){
                    union(partyInfo[i][j - 1], partyInfo[i][j]);
                }
            }
        }
        int kingLiar = find(liar[1]);
        for(int i = 0; i < M; i++){
            boolean isLiar = false;
            for(int j = 0; j < partyInfo[i].length; j++){
                if(kingLiar == find(partyInfo[i][j])){
                    isLiar = true;
                    break;
                }
            }
            if(!isLiar){
                ans++;
            }
        }
        System.out.print(ans);
    }
    public static int find(int x){
        if(parents[x] == x){
            return x;
        }
        else{
            return parents[x] = find(parents[x]);
        }
    }
    public static void union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) return;
        int h = parents[xParent]<=parents[xParent]?xParent:yParent;
        int l = parents[xParent]<=parents[xParent]?yParent:xParent;
        parents[l] = h;
    }
}
