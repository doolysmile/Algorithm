package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B17386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Node node1 = new Node(temp[0], temp[1], temp[2], temp[3]);
        temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Node node2 = new Node(temp[0], temp[1], temp[2], temp[3]);
        long ans = checkCross(node1, node2) ? 1 : 0;
        System.out.println(ans);
    }
    private static boolean checkCross(Node node1, Node node2) {
        if(ccw(node1.x1, node1.y1, node1.x2, node1.y2, node2.x1, node2.y1) * ccw(node1.x1, node1.y1, node1.x2, node1.y2, node2.x2, node2.y2) > 0){
            return false;
        }
        if(ccw(node2.x1, node2.y1, node2.x2, node2.y2, node1.x1, node1.y1) * ccw(node2.x1, node2.y1, node2.x2, node2.y2, node1.x2, node1.y2) > 0) {
            return false;
        }
        return true;
    }
    private static long ccw(long x1, long y1, long x2, long y2, long x3, long y3){
        return (x1*y2 + x2*y3 + x3*y1) - (y1*x2 + y2*x3 + y3*x1) < 0 ? -1 : 1;
    }
    static class Node{
        long x1;
        long y1;
        long x2;
        long y2;
        long parent;
        public Node(long x1, long y1, long x2, long y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.parent = -1;
        }
    }
}