package git.Algorithm.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class OpenChatting {
    public String[] solution(String[] record) {

        HashMap<String, String> info = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String[] tmp_msg = {};
        for(String msg : record){
            String tmp[] = msg.split(" ");
            if(tmp[0].equals("Enter")){
                info.put(tmp[1], tmp[2]);
                sb.append(tmp[1] + " ");
                sb.append("Enter ");
            }
            else if(tmp[0].equals("Change")){
                info.put(tmp[1], tmp[2]);
            }
            else{
                sb.append(tmp[1] + " ");
                sb.append("Leave ");
            }
        }
        tmp_msg = sb.toString().split(" ");
        info.put("Enter", "님이 들어왔습니다");
        info.put("Leave", "님이 나갔습니다");
        String[] answer = new String[tmp_msg.length/2];
        for(int i = 0 ; i < tmp_msg.length; i = i + 2){
            String tmp = info.get(tmp_msg[i]) + info.get(tmp_msg[i + 1]);
            answer[(i + 1)/2] = tmp;
        }
        return answer;
    }
}
