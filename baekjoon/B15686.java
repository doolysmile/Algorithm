package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B15686 {
    static int ans;
    static int M;
    static int size;
    static int N;
    static List<Node> chicken;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        chicken = new ArrayList<>();
        int[] order = new int[M];
        ans = Integer.MAX_VALUE;
        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 2){
                    tmp = 0;
                    chicken.add(new Node(i, j));
                }
                map[i][j] = tmp;
            }
        }
        size = chicken.size();
        chickenOrder(order, 0, 0);
        System.out.println(ans);
    }
    static void chickenOrder(int[] order, int current, int index){
        if(index == M){
            calDistance(order);
            return;
        }
        if(current == size){
            return;
        }
        chickenOrder(order, current+ 1, index);
        order[index] = current;
        chickenOrder(order, current + 1, index + 1);
    }
    static void calDistance(int[] order){
        int tmpAns = 0;
        int dis = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    dis = Integer.MAX_VALUE;
                    for(int k : order){
                        int temp = Math.abs(chicken.get(k).x - i) + Math.abs(chicken.get(k).y -j);
                        dis = Math.min(dis, temp);
                    }
                    tmpAns += dis;
                }
            }
        }
        ans = Math.min(ans, tmpAns);
    }
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
