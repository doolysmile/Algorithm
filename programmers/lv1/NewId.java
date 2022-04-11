package git.Algorithm.programmers.lv1;

public class NewId {
    public String solution(String new_id) {
        String answer = "";

        //step 1
        new_id = new_id.toLowerCase();

        //step 2
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        //step 3
        new_id = new_id.replaceAll("\\.+", ".");

        //step 4
        if(new_id.length() > 0) {
            if (new_id.charAt(0) == '.') {
                new_id = new_id.substring(1, new_id.length());
            }
        }
        if(new_id.length() > 0) {
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        //step 5
        if(new_id.length() == 0){
            new_id =  "a";
        }

        //step 6
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(new_id.length() - 1) == '.'){
                new_id = new_id.substring(0,new_id.length() - 1);
            }
        }

        //step 7
        if(new_id.length() <= 2){
            char tmp = new_id.charAt(new_id.length() - 1);
            while(new_id.length() < 3){
                new_id = new_id + tmp;
            }
        }

        answer = new_id;
        return answer;
    }

}

/**
 * 다른 사람 풀이
 * 코드 재사용성을 고려하기
 *
 */

//class Solution {
//    public String solution(String new_id) {
//
//        String s = new KAKAOID(new_id)
//                .replaceToLowerCase()
//                .filter()
//                .toSingleDot()
//                .noStartEndDot()
//                .noBlank()
//                .noGreaterThan16()
//                .noLessThan2()
//                .getResult();
//
//
//        return s;
//    }
//
//    private static class KAKAOID {
//        private String s;
//
//        KAKAOID(String s) {
//            this.s = s;
//        }
//
//        private KAKAOID replaceToLowerCase() {
//            s = s.toLowerCase();
//            return this;
//        }
//
//        private KAKAOID filter() {
//            s = s.replaceAll("[^a-z0-9._-]", "");
//            return this;
//        }
//
//        private KAKAOID toSingleDot() {
//            s = s.replaceAll("[.]{2,}", ".");
//            return this;
//        }
//
//        private KAKAOID noStartEndDot() {
//            s = s.replaceAll("^[.]|[.]$", "");
//            return this;
//        }
//
//        private KAKAOID noBlank() {
//            s = s.isEmpty() ? "a" : s;
//            return this;
//        }
//
//        private KAKAOID noGreaterThan16() {
//            if (s.length() >= 16) {
//                s = s.substring(0, 15);
//            }
//            s = s.replaceAll("[.]$", "");
//            return this;
//        }
//
//        private KAKAOID noLessThan2() {
//            StringBuilder sBuilder = new StringBuilder(s);
//            while (sBuilder.length() <= 2) {
//                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
//            }
//            s = sBuilder.toString();
//            return this;
//        }
//
//        private String getResult() {
//            return s;
//        }
//    }
//}