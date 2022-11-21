package git.Algorithm.programmers.lv2;

import java.util.ArrayList;

public class NewsClustering {
    public int solution(String str1, String str2) {
        double answer = 0;
        ArrayList<String> strSet1 = new ArrayList<>();
        ArrayList<String> strSet2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i = 0 ; i < str1.length() - 1 ; i++){
            char front = str1.charAt(i);
            char back = str1.charAt(i + 1);
            if('a' <= front && front <= 'z' && 'a' <= back && back <= 'z'){
                strSet1.add(front + "" + back);
            }
        }

        for(int i = 0 ; i < str2.length() - 1 ; i++){
            char front = str2.charAt(i);
            char back = str2.charAt(i + 1);
            if('a' <= front && front <= 'z' && 'a' <= back && back <= 'z'){
                strSet2.add(front + "" + back);
            }
        }

        for(String s : strSet1){
            if(strSet2.contains(s)){
                strSet2.remove(s);
                intersection.add(s);
            }
            union.add(s);
        }

        for(String s : strSet2){
            union.add(s);
        }



        if(union.size() == 0) {
            answer = 1;
        } else {
            answer = (double)intersection.size() / (double)union.size();
        }

        return (int)(answer * 65536);
    }
}
