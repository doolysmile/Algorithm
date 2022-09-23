package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4256 {
    static int N;
    static int[] preorder; // cur, left, right
    static int[] inorder;  // left, root, right
    static int[] postorder; // right, left, cur
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        int temp;
        for(int i = 0; i < N; i++){
            temp = Integer.parseInt(br.readLine());
            preorder = new int[temp + 1];
            inorder = new int[temp + 1];
            postorder = new int[temp + 1];
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < temp; k++){
                preorder[k] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < temp; k++){
                inorder[k] = Integer.parseInt(st.nextToken());
            }

            makePostOrder(0,0, temp);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    static void makePostOrder(int current, int start, int end){
        int rootIdx = preorder[current];
        for(int i=start; i<end; i++) {
            if(inorder[i] == rootIdx) {
                makePostOrder(current+1, start,i);
                makePostOrder(current+i+1-start, i+1,end);
                sb.append(rootIdx +" ");
            }
        }
    }

}
