//package git.Algorithm.baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class B21608 {
//    static int[][] position;
//    static int N;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        N = Integer.parseInt(br.readLine());
//        int powN = (int) Math.pow(N, 2);
//        int[][] students = new int[powN][5];
//        position = new int[N + 2][N + 2];
//        for(int i = 0; i < powN; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < 5; j++){
//                students[i][j] = Integer.parseInt(st.nextToken());
//            }
//
//        }
//
//
//    }
//
//    public static void findPosition(int[] student){
//        int stu = student[0];
//        ArrayList<int[][]> list = new ArrayList<>();
//        int tmp = 0;
//        int[] x = {1, 0, -1, 0};
//        int[] y = {0 , 1, 0, -1};
//        for(int i = 1; i <= N ; i++){
//            for(int j = 1; j <= N ; j++){
//                for(int k = 0; k < 4; k++){
//                    position[i + x[k]][j +]
//                }
//            }
//        }
//    }
//
//}
