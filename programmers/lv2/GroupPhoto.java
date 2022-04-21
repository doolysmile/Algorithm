package git.Algorithm.programmers.lv2;


public class GroupPhoto {
    static boolean[] check = new boolean[8];
    static int answer = 0;
    static String[] result = new String[8];
    public int solution(int n, String[] data) {
        answer = 0;
        check = new boolean[8];
        String[] character = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};

        dfs(data, character, 0);
        return answer;
    }

    public void dfs(String[] data, String[] character, int cnt) {
        if(cnt == 8){
            String order = "";
            for(int i = 0; i < 8; i++){
                order += result[i];
            }

            if(ch(data, order)) {
                answer++;
            }
            return ;
        }
        for (int i = 0; i < 8; i++) {
            if (check[i] == false) {
                check[i] = true;
                result[cnt] = character[i];
                dfs(data, character, cnt + 1);
                check[i] = false;
            }

        }


    }
    public boolean ch(String[] data, String order) {

        for(int i = 0; i < data.length; i++){
            int first = order.indexOf(data[i].charAt(0));
            int second = order.indexOf(data[i].charAt(2));

            char comp = data[i].charAt(3);
            int comNum = Integer.parseInt(data[i].substring(4,5)) + 1;
            if(comp == '=' && Math.abs(first - second)  != comNum){
                return false;
            } else if(comp == '<' && Math.abs(first - second)  >= comNum) {
                return false;
            } else if(comp == '>' && Math.abs(first - second)  <= comNum) {
                return false;
            }

        }

        return true;
    }

}