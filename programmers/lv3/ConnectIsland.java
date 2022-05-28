package git.Algorithm.programmers.lv3;
import java.util.*;
public class ConnectIsland {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        Arrays.sort(costs, (a,b)->{return a[2] - b[2];});
        for(int i = 0 ; i < n; i++){
            parent[i] = i;
        }


        for(int[] cost : costs){
            int from = cost[0];
            int to = cost[1];

            int fromParent = findParent(from);
            int toParent = findParent(to);
            if(fromParent == toParent){
                continue;
            }
            answer += cost[2];

            parent[toParent] = fromParent;
        }


        return answer;
    }
    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }
        return findParent(parent[node]);
    }

}

