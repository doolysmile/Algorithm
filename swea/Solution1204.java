package git.Algorithm.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1204
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int max = 10;
            int ans = -1;
            int[] score = new int[101];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 1000; i++){
                int temp = Integer.parseInt(st.nextToken());
                score[temp]++;
                if(score[temp] > max){
                    max = score[temp];
                    ans = temp;
                }
                else if(score[temp] == max){
                    if(temp > ans){
                        ans = temp;
                    }
                }
            }
            sb.append("#" + N + " " + ans + "\n");
        }
        System.out.println(sb);

    }
}
