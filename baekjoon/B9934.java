package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9934 {
    static ArrayList[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        int num = (int) (Math.pow(2, K) - 1);
        tree = new ArrayList[K];
        for(int i = 0; i < K; i++){
            tree[i] = new ArrayList<Integer>();
        }
        st = new StringTokenizer(br.readLine());
        int input[] = new int[num];
        int i = 0;
        while(st.hasMoreTokens()){
            input[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        middle(0,0, num - 1, input, K);
        for(int j = 0; j < K; j++){
            for(int k = 0; k < tree[j].size(); k++){
                sb.append(tree[j].get(k) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void middle(int depth, int start, int end, int[] input, int K){
        if(depth == K){
            return;
        }
        int middle = (start + end)/2;
        tree[depth].add(input[middle]);

        middle(depth + 1, 0, middle-1, input, K);
        middle(depth + 1, middle + 1, end, input, K);
    }
}
