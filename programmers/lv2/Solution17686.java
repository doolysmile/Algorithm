package git.Algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution17686 {
    static ArrayList<File> ans;
    public String[] solution(String[] files) {
        // 원본, head, num, tail
        String[] answer = new String[files.length];
        ans = new ArrayList<>();
        for(String file : files){
            converter(file);
        }
        Collections.sort(ans, new FileComparator());
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i).raw;
        }
        return answer;
    }
    static class FileComparator implements Comparator<File>{
        @Override
        public int compare(File o1, File o2) {
            if(o1.head.compareTo(o2.head) != 0){
                return o1.head.compareTo(o2.head);
            }
            else{
                return o1.num - o2.num;
            }
        }
    }
    static class File {
        String raw;
        String head;
        int num;
        File(String raw, String head, int num){
            this.raw = raw;
            this.head = head;
            this.num = num;
        }


    }
    public void converter(String file){
        StringBuilder sb = new StringBuilder();
        // 0 head, 1 num, 2 tail
        boolean numCheck = true;
        boolean headCheck = true;
        String head = "";
        int num  = 0;
        String tail = "";
        for(int i = 0; i < file.length(); i++){
            char c = file.charAt(i);
            if('0' <= c && c <= '9'){
                if(headCheck){
                    head = sb.toString().toLowerCase();
                    sb = new StringBuilder();
                    headCheck = false;
                }
                sb.append(c);
            }
            else if(headCheck){
                sb.append(c);
            }
            else if(!headCheck) {
                break;
            }
        }
        num = Integer.valueOf(sb.toString());
        ans.add(new File(file, head, num));
    }


    public static void main(String[] args) {
        Solution17686 s = new Solution17686();
        String[] strings = new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(s.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
    }
}
