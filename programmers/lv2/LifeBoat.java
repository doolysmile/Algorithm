package git.Algorithm.programmers.lv2;

import java.util.Arrays;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = people.length;
        Arrays.sort(people);
        int j = 0;
        int maxtmp = people.length;
        for(int i = 0; i < people.length/2; i++){
            j = maxtmp - 1;
            while(true){
                if(j <= i){
                    return answer;
                }
                if(people[i] + people[j] <= limit){
                    maxtmp = j;
                    answer--;
                    break;
                }
                j--;
            }
        }
        return answer;
    }

    /**
     *     다른 사람 풀이 - 탐색 하는게 훨씬 간결함
     *           for (; i < j; --j) {
     *             if (people[i] + people[j] <= limit)
     *                 ++i;
     *         }
     *         
     */

//    public int solution(int[] people, int limit) {
//        Arrays.sort(people);
//        int i = 0, j = people.length - 1;
//        for (; i < j; --j) {
//            if (people[i] + people[j] <= limit)
//                ++i;
//        }
//        return people.length - i;
//    }

}
