package git.Algorithm.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B14865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        // 0은 x, 1은 y
        int[][] input = new int[N][2];
        // 음수를 찾기 위해
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Node> nodes = new ArrayList<>();

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            input[n][0] = Integer.parseInt(st.nextToken());
            input[n][1] = Integer.parseInt(st.nextToken());
            q.add(input[n]);
        }
        // 처음에 음수가 나오도록 정렬
        while(true) {
            int[] temp = q.peek();
            if(temp[1] < 0) {
                break;
            }
            else{
                q.add(q.poll());
            }
        }
        boolean isMinus = true;
        boolean hasStart = false;
        int startX = 0;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            if(isMinus && temp[1] < 0) {
                continue;
            }
            if(isMinus && temp[1] > 0 && !hasStart) {
                hasStart = true;
                startX = temp[0];
                isMinus = false;
                continue;
            }
            if(!isMinus && temp[1] < 0) {
                int small = Math.min(startX, temp[0]);
                int large = Math.max(startX, temp[0]);
                nodes.add(new Node(small, large));
                isMinus = true;
                hasStart = false;
            }
            // 마지막
            if(!isMinus && temp[1] > 0 && q.isEmpty()) {
                int small = Math.min(startX, temp[0]);
                int large = Math.max(startX, temp[0]);
                nodes.add(new Node(small, large));
            }
        }
        PriorityQueue<Point> points = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.num - o2.num;
            }
        });
        for(Node temp : nodes){
            points.add(new Point(temp.smallX, true));
            points.add(new Point(temp.LargeX, false));
        }
        int outCnt = 0;
        int inCnt = 0;
        boolean inCheck = false;
        Stack<Point> stack = new Stack<>();
        while(!points.isEmpty()){
            Point temp = points.poll();
            if(stack.isEmpty()){
                outCnt++;
            }
            if(temp.up){
                inCheck = true;
                stack.push(temp);
            }
            else{
                if(inCheck){
                    inCnt++;
                }
                inCheck = false;
                stack.pop();
            }
        }
        // 시간을 너무 많이 씀, 정렬 후 비교 하면 더 좋을듯

//        for(int i = 0; i < nodes.size(); i++) {
//            boolean outCheck = true;
//            boolean inCheck = true;
//            for(int j = 0; j < nodes.size(); j++) {
//                if(i == j) {
//                    continue;
//                }
//                // 바깥에 뭐가 있나?
//                if(nodes.get(j).smallX < nodes.get(i).smallX && nodes.get(i).LargeX < nodes.get(j).LargeX) {
//                    outCheck = false;
//                }
//                // 안에 뭐가 있나?
//                else if(nodes.get(i).smallX < nodes.get(j).smallX && nodes.get(j).LargeX < nodes.get(i).LargeX) {
//                    inCheck = false;
//                }
//
//            }
//            if(outCheck) {
//                outCnt++;
//            }
//            if(inCheck) {
//                inCnt++;
//            }
//        }
        System.out.println(outCnt + " " + inCnt);
    }
    static class Point{
        int num;
        boolean up;
        Point(int num, boolean up){
            this.num = num;
            this.up = up;
        }
    }

    static class Node{
        int smallX;
        int LargeX;
        Node(int smallX, int LargeX){
            this.smallX = smallX;
            this.LargeX = LargeX;
        }
    }
}
