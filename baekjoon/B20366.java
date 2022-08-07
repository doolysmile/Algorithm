package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B20366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] H = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < N - 1; i++){
            for(int j = i+1; j < N; j++){
                int firstSnowMan = H[i] + H[j];
                int secondSnowMan = Integer.MAX_VALUE;
                int start = 0;
                int end = N - 1;

                while(start < end){
                    if(start == i || start == j){
                        start++;
                        continue;
                    }
                    if(end == j || end == i){
                        end--;
                        continue;
                    }
                    secondSnowMan = H[start] + H[end];
                    if(ans > Math.abs(secondSnowMan - firstSnowMan)){
                        ans = Math.abs(secondSnowMan - firstSnowMan);
                    }
                    if(firstSnowMan > secondSnowMan){
                        start++;
                    }
                    else if(firstSnowMan < secondSnowMan){
                        end--;
                    }
                    else if(firstSnowMan == secondSnowMan){
                        System.out.println(0);
                        return;
                    }


                }

            }
        }
        System.out.println(ans);
    }


    // 아래 코드는 시간 초과

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] H = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
//        int ans = Integer.MAX_VALUE;
//        for(int i = 0; i < N - 1; i++){
//            for(int j = i+1; j < N; j++){
//                int firstSnowMan = H[i] + H[j];
//                int secondSnowMan = Integer.MAX_VALUE;
//
//                for(int start = i + 1; start < N - 1; start++){
//                    if(start == j){
//                        continue;
//                    }
//                    int end = start + 1;
//                    if(H[start] + H[end] > secondSnowMan){
//                        break;
//                    }
//                    while(end < N){
//                        if(end == j){
//                            end++;
//                            continue;
//                        }
//                        secondSnowMan = H[start] + H[end];
//                        ans = Math.abs(secondSnowMan - firstSnowMan) < ans ? Math.abs(secondSnowMan - firstSnowMan) : ans;
//                        if(secondSnowMan > firstSnowMan){
//                            break;
//                        }
//                        end++;
//                    }
//                }
//
//            }
//        }
//        System.out.println(ans);
//    }
}
