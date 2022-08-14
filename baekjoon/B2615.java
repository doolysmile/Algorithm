package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2615 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        arr = new int[19][19];
        boolean check = false;
        for(int i = 0; i < 19; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(arr[i][j] != 0){

                    check = classification(i, j, arr[i][j], 1);
                    if(check){
                        sb.append(arr[i][j] + "\n" + (i+1) + " " + (j + 1));
                        break;
                    }
                }
            }
            if(check){
                break;
            }
        }
        if(!check){
            sb.append(0);
        }
        System.out.println(sb.toString());
    }
    static boolean classification(int i , int j, int color, int cnt){
        boolean check = false;
        if(j + 1 < 19 && arr[i][j + 1] == color){
            check =  bfsWin(i, j + 1, color, cnt + 1, 1);
            if(j > 0 && arr[i][j  - 1] == arr[i][j]){
                check = false;
            }
            if(check){
                return check;
            }
        }
        if(i + 1 < 19 && arr[i + 1][j] == color){
            check = bfsWin(i + 1, j, color, cnt + 1, 2);
            if(i > 0 && arr[i - 1][j] == arr[i][j]){
                check = false;
            }
            if(check){
                return check;
            }
        }
        if(i + 1 < 19 && j + 1 < 19 && arr[i + 1][j + 1] == color){
            check = bfsWin(i + 1, j + 1, color, cnt + 1, 3);
            if(i > 0 &&j > 0 && arr[i - 1][j  - 1] == arr[i][j]){
                check = false;
            }
            if(check){
                return check;
            }
        }
        if(i - 1 >= 0 && j +  1 < 19 && arr[i - 1][j + 1] == color){
            check =  bfsWin(i - 1, j +  1, color, cnt + 1, 4);
            if(i + 1 < 19 &&j > 0 && arr[i + 1][j  - 1] == arr[i][j]){
                check = false;
            }
            if(check){
                return check;
            }
        }
        return check;
    }
    // 0 초기값, 1 가로 , 2 세로, 3 대각선 오른쪽 아래 4 대각선 오른쪽 위로
    static boolean bfsWin(int i , int j, int color, int cnt, int direction){
        if(direction == 1){
            if(cnt == 5){
                if(j + 1 < 19 && arr[i][j+1] == color){
                    return false;
                }
                return true;
            }
            if(j + 1 < 19 && arr[i][j + 1] == color){
                return bfsWin(i, j + 1, color, cnt + 1, 1);
            }
        }
        if(direction == 2){
            if(cnt == 5){
                if(i + 1 < 19 && arr[i + 1][j] == color){
                    return false;
                }
                return true;
            }
            if(i + 1 < 19 && arr[i + 1][j] == color){
                return bfsWin(i + 1, j, color, cnt + 1, 2);
            }
        }
        if(direction == 3){
            if(cnt == 5){
                if(i + 1 < 19 && j + 1 < 19 && arr[i + 1][j + 1] == color){
                    return false;
                }
                return true;
            }
            if(i + 1 < 19 && j + 1 < 19 && arr[i + 1][j + 1] == color){
                return bfsWin(i + 1, j + 1, color, cnt + 1, 3);
            }
        }
        if(direction == 4){
            if(cnt == 5){
                if(i - 1 >= 0 && j +  1 < 19 && arr[i - 1][j + 1] == color){
                    return false;
                }
                return true;
            }
            if(i - 1 >= 0 && j +  1 < 19 && arr[i - 1][j + 1] == color){
                return bfsWin(i - 1, j +  1, color, cnt + 1, 4);
            }
        }
        return false;
    }
}
