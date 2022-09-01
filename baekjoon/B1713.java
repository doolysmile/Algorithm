package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        int[] recommend = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] num = new int[N];
        int[] numCnt = new int[N];
        int[] numOrder = new int[N];
        int order = 0;
        int numEmpty = 0;
        boolean check = false;
        // {번호, 갯수, 순서}
        for(int i = 0; i < cnt; i++){
            check = false;
            for(int j = 0; j < N; j++){
                if(num[j] == recommend[i]){
                    numCnt[j]++;
                    check = true;
                    break;
                }
            }
            // 새로들어온 경우
            if(!check){
                if(numEmpty < N){
                    num[numEmpty] = recommend[i];
                    numCnt[numEmpty] = 1;
                    numOrder[numEmpty] = order;
                    numEmpty++;
                }
                else{
                    int tmp = 0;
                    for(int j = 0; j < N; j++){
                        if(numCnt[j] < numCnt[tmp]){
                            tmp = j;
                        }
                        else if(numCnt[j] == numCnt[tmp]){
                            if(numOrder[j] < numOrder[tmp]){
                                tmp = j;
                            }
                        }
                    }
                    num[tmp] = recommend[i];
                    numCnt[tmp] = 1;
                    numOrder[tmp] = order;
                }
                order++;
            }
        }
        Arrays.sort(num);
        for(int i = 0; i < N; i++){
            if(num[i] != 0){
                sb.append(num[i]);
                if(i != N - 1){
                    sb.append(" ");
                }
            }

        }
        System.out.print(sb);
    }
}
