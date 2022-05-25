package git.Algorithm.programmers.lv2;

public class RotationRec {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] rec = new int[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                rec[i][j] = i*columns + j+1;
            }
        }
        for(int i = 0; i < queries.length; i++){
            answer[i] = lotation(rec, queries[i]);


        }
        return answer;
    }
    //x1, y1, x2, y2
    public int lotation(int[][] rec, int[] query){
        int x1 = query[0] - 1; //1
        int y1 = query[1] - 1; //1
        int x2 = query[2] - 1; //4
        int y2 = query[3] - 1; //3
        int start = rec[x1][y1];
        int min = start;
        for(int i = x1; i < x2; i++){
            rec[i][y1] = rec[i+1][y1];
            if(rec[i][y1] < min){
                min = rec[i][y1];
            }
        }

        for(int i = y1; i < y2; i++){
            rec[x2][i] = rec[x2][i +1];
            if(rec[x2][i] < min){
                min = rec[x2][i];
            }

        }
        for(int i = x2; i > x1 ; i--){
            rec[i][y2] = rec[i-1][y2];
            if(rec[i][y2] < min){
                min = rec[i][y2];
            }
        }
        for(int i = y2; i > y1 ; i--){
            rec[x1][i] = rec[x1][i-1];
            if(rec[x1][i] < min){
                min = rec[x1][i];
            }
        }
        rec[x1][y1+1] = start;


        return min;
    }
}
