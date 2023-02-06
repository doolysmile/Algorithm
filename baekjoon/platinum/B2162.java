package git.Algorithm.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2162 {
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int group = 0;
        int cnt = 0;
        nodes = new Node[N];
        for(int i = 0; i < N; i++){
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodes[i] = new Node(temp[0], temp[1], temp[2], temp[3]);
        }
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                boolean isCross = false;
                if(findParent(i) != findParent(j)){
                    isCross = checkCross(i, j);
                }
                if(isCross){
                    union(i, j);
                }
            }
        }
        for(int i = 0; i < N; i++){
            if(nodes[i].parent < 0){
                group++;
                cnt = Math.min(cnt, nodes[i].parent);
            }
        }
        System.out.println(group);
        System.out.println(-cnt);
    }



    private static boolean checkCross(int f, int s) {
        int p123 = ccw(nodes[f].x1, nodes[f].y1, nodes[f].x2, nodes[f].y2, nodes[s].x1, nodes[s].y1);
        int p124 = ccw(nodes[f].x1, nodes[f].y1, nodes[f].x2, nodes[f].y2, nodes[s].x2, nodes[s].y2);
        int p134 = ccw(nodes[f].x1, nodes[f].y1, nodes[s].x1, nodes[s].y1, nodes[s].x2, nodes[s].y2);
        int p234 = ccw(nodes[f].x2, nodes[f].y2, nodes[s].x1, nodes[s].y1, nodes[s].x2, nodes[s].y2);
        boolean compare1 = Math.min(nodes[f].x1, nodes[f].x2) <= Math.max(nodes[s].x1, nodes[s].x2);
        boolean compare2 = Math.min(nodes[s].x1, nodes[s].x2) <= Math.max(nodes[f].x1, nodes[f].x2);
        boolean compare3 = Math.min(nodes[f].y1, nodes[f].y2) <= Math.max(nodes[s].y1, nodes[s].y2);
        boolean compare4 = Math.min(nodes[s].y1, nodes[s].y2) <= Math.max(nodes[f].y1, nodes[f].y2);
        if(p123 * p124 == 0 && p134 * p234 == 0){
            if (compare1 && compare2 && compare3 && compare4){

                return true;
            }
            else
                return false;
        }
        if(p123 * p124 > 0){
            return false;
        }
        if(p134 * p234 > 0) {
            return false;
        }
        return true;
    }
    private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3){
        long result =  (x1*y2 + x2*y3 + x3*y1) - (y1*x2 + y2*x3 + y3*x1);
        if(result > 0){
            return 1;
        }
        if(result == 0){
            return 0;
        }
        return  -1;
    }
    static int findParent(int i){
        if(nodes[i].parent < 0){
            return i;
        }
        return findParent(nodes[i].parent);
    }
    // i < j보장
    // 1<- 2 3
    private static void union(int i, int j) {
        int parentI = findParent(i);
        int parentJ = findParent(j);

        int low = parentI < parentJ ? parentI : parentJ;
        int high = parentI > parentJ ? parentI : parentJ;
        nodes[low].parent = nodes[low].parent + nodes[high].parent;
        nodes[high].parent = low;
    }
    static class Node{
        int x1;
        int y1;
        int x2;
        int y2;
        int parent;
        public Node(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.parent = -1;
        }
    }
}
class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
