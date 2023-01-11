package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B10026 {
    static boolean[][] check;
    static int[] dx;
    static int[] dy;
    static Queue<Node> q;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[][] input = new String[N][N];
        int rgb = 0;
        int rg = 0;
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        check = new boolean[N][N];
        q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            input[i] = br.readLine().split("");
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!check[i][j]){
                    q.add(new Node(i, j));
                    check[i][j] = true;
                    rgb++;
                    divedRGB(input, input[i][j]);
                }
            }
        }
        check = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!check[i][j]){
                    q.add(new Node(i, j));
                    check[i][j] = true;
                    rg++;
                    divedRG(input, input[i][j]);
                }
            }
        }
        System.out.println(rgb + " " + rg);
        check = new boolean[N][N];
    }

    private static void divedRGB(String[][] input, String target) {
        while(!q.isEmpty()){
            Node temp = q.poll();
            for(int i = 0; i < 4; i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(0 <= x && x < N && 0 <= y && y < N && input[x][y].equals(target) && !check[x][y]){
                    check[x][y] = true;
                    q.add(new Node(x, y));
                }
            }
        }
    }
    private static void divedRG(String[][] input, String target) {
        String[] comp;
        if(target.equals("B")){
            comp = new String[]{"B"};
        }
        else{
            comp = new String[]{"R", "G"};
        }
        while(!q.isEmpty()){
            Node temp = q.poll();
            for(int i = 0; i < 4; i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(0 <= x && x < N && 0 <= y && y < N ){
                    for(int j = 0; j < comp.length; j++){
                        if(comp[j].equals(input[x][y]) && !check[x][y]){
                            check[x][y] = true;
                            q.add(new Node(x, y));
                        }
                    }
                }
            }
        }
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
