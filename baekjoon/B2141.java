package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][2];
        long sumPerson = 0;
        long sumLeft = 0;
        int answer = 0;
        for(int i = 0; i < N; i++){
            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(input, (a,b) -> a[0]-b[0]);
        for(int i = 0; i < N ; i++){
            sumPerson += input[i][1];
        }
        for(int i = 0; i < N; i++){
            sumLeft += input[i][1];
            if(sumLeft*2 >= sumPerson){
                System.out.println(input[i][0]);
                break;
            }
        }
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[][] input = new int[N][2];
//        long sumLength = 0;
//        long sumPerson = 0;
//        long sumLeft = 0;
//        int prePostOffice;
//        int answer = 0;
//        for(int i = 0; i < N; i++){
//            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        }
//        Arrays.sort(input, (a,b) -> a[0]-b[0]);
//        prePostOffice = input[0][0];
//        for(int i = 0; i < N ; i++){
//            sumPerson += input[i][1];
//            sumLength += Math.abs(input[i][0] - prePostOffice) * input[i][1];
//        }
//        sumLeft = input[0][1];
//        answer = input[0][0];
//        for(int i = 1; i < N; i++){
//            long tmp = sumLength + sumLeft*(input[i][0] - prePostOffice) - ((sumPerson - sumLeft)*(input[i][0] - prePostOffice));
//            if(tmp < sumLength){
//                sumLength = tmp;
//                answer = input[i][0];
//            }
//            prePostOffice = input[i][0];
//            sumLeft += input[i][1];
//        }
//        System.out.println(answer);
//    }
}
