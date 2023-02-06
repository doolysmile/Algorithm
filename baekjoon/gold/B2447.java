package git.Algorithm.baekjoon.gold;

import java.util.Scanner;
/*
9구역
1 1 1
1 0 1
1 1 1
한줄씩 찍기X
배열
$$$
$ $
$$$
 */
public class B2447 {
    static StringBuilder sb;
    static String[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        int N = sc.nextInt();
        map = new String[N + 1][N + 1];
        recur(N, 1, 1);
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.printf(sb.toString());
    }
/*
1 2 3
4 5 6
7 8 9
 */
    private static void recur(int n, int x, int y) {
        int sector = 0;
        // 1일때 별 찍기
        if(n == 1){
            map[x][y] = "*";
            return;
        }
        // 섹터별 for문
        // n/3씩 커져야 섹터를 검색 가능
        for(int i = x; i < x + n; i = i + n/3){
            for(int j = y; j < y + n; j = j + n/3){
                sector++;
                // 중앙이 아닐떄 재귀 호출
                if(sector != 5){

                    recur(n/3, i, j);
                }
                // 중앙일때 빈 칸으로 채우기
                else{
                    for(int k = i; k <= i + n/3; k++){
                        for(int l = j; l <= j + n/3; l++){
                            map[k][l] = " ";
                        }
                    }
                }
            }
        }
    }

}