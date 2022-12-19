package git.Algorithm.programmers.lv3;

import java.util.*;

public class Solution64064 {
    static String[] banned;
    static boolean[] check;
    static int answer;
    static int uCnt;
    static int bCnt;
    static HashSet<HashSet<String>> list;
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        check = new boolean[user_id.length];
        uCnt = user_id.length;
        bCnt = banned_id.length;
        banned = Arrays.stream(banned_id).map(s -> s.replace("*", ".")).toArray(String[]::new);
        list = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        dfs(0, user_id, set);
        return answer;
    }

    public void dfs(int current, String[] user_id, HashSet<String> set) {
        if(current == bCnt){
            if(isExisted(new HashSet<>(set)))
                answer++;
            return;
        }
        for(int j = 0; j < uCnt; j++){
            if(!check[j] && user_id[j].matches(banned[current])){
                check[j] = true;
                set.add(user_id[j]);
                dfs(current + 1, user_id, set);
                set.remove(user_id[j]);
                check[j] = false;
            }
        }
    }
    public boolean isExisted(HashSet<String> set){
        if(list.add(set)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        Solution64064 s = new Solution64064();
        s.solution(user_id, banned_id);
    }
}
