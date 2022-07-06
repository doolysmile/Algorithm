package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1991 {
    static int[][] tree;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        tree = new int[N][2];
        // A = 65
        for(int i = 0; i < N ; i++){
            char[] tmp = br.readLine().replace(" ","").toCharArray();
            int index = tmp[0] - 65;
            if(tmp[1] == '.'){
                tree[index][0] = -1;
            }
            else{
                tree[index][0] = tmp[1] - 65;
            }
            if(tmp[2] == '.'){
                tree[index][1] = -1;
            }
            else{
                tree[index][1] = tmp[2] - 65;
            }
        }
        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        System.out.println(sb.toString());
    }
    static void preorder(int current){
        char tmp  = (char)(current+65);
        sb.append(tmp);
        if(tree[current][0] != -1){
            preorder(tree[current][0]);
        }
        if(tree[current][1] != -1){
            preorder(tree[current][1]);
        }

    }
    static void inorder(int current){
        if(tree[current][0] != -1){
            inorder(tree[current][0]);
        }
        char tmp  = (char)(current+65);
        sb.append(tmp);
        if(tree[current][1] != -1){
            inorder(tree[current][1]);
        }
    }
    static void postorder(int current){
        if(tree[current][0] != -1){
            postorder(tree[current][0]);
        }
        if(tree[current][1] != -1){
            postorder(tree[current][1]);
        }
        char tmp  = (char)(current+65);
        sb.append(tmp);

    }
}
