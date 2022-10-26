package git.Algorithm.programmers.lv2;

public class ThatSongJustNow {
    // C, C#, D, D#, E, F, F#, G, G#, A, A#, B
    //    c,     d          f      g      a
    public String solution(String m, String[] musicinfos) {
        String compMelody = change(m);
        String answer = "(None)";
        int playtime = -1;
        for(String musicinfo : musicinfos){
            String[] temp = musicinfo.split(",");
            String[] startTime = temp[0].split(":");
            String[] endTime = temp[1].split(":");
            // 한번에 계산하면 시간이 이상하게 나옴
            int end = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
            int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            int time = end - start;
//            int time = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1])
//                    - Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);

            String melody = change(temp[3]);
            int diff = time - melody.length();
            if(diff > 0){
                StringBuilder sb = new StringBuilder(melody);
                for(int i = 0; i < diff / melody.length(); i++){
                    sb.append(melody);
                }
                sb.append(melody.substring(0, diff % melody.length()));
                melody = sb.toString();
            }
            else{
                melody = melody.substring(0, time);
            }
            System.out.println(melody);
            if(melody.contains(compMelody)){
                if(time > playtime){
                    playtime = time;
                    answer = temp[2];
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
    public String change(String s){
        s = s.replace("C#", "c");
        s = s.replace("D#", "d");
        s = s.replace("F#", "f");
        s = s.replace("G#", "g");
        s = s.replace("A#", "a");
        return s;
    }

    public static void main(String[] args) {
        ThatSongJustNow t = new ThatSongJustNow();
        String[] temp = {"11:50,12:04,HELLO,CDEFGAB", "12:57,13:11,BYE,CDEFGAB"};
        t.solution("ABCDEFG", temp);
    }
}
