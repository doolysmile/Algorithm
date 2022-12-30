package git.Algorithm.programmers.lv3;

import java.util.*;

public class Solution42579 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, HashMap<Integer, Integer>> list = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            if(list.containsKey(genres[i])){
                list.get(genres[i]).put(i, plays[i]);
            }
            else{
                HashMap<Integer, Integer> temp = new HashMap<>();
                temp.put(i, plays[i]);
                list.put(genres[i], temp);
            }
        }
        List<String> genresSet = new ArrayList<>(list.keySet());
        Collections.sort(genresSet, (o1, o2) -> map.get(o2) - map.get(o1));
        for(String genre : genresSet){
            HashMap<Integer, Integer> temp = list.get(genre);
            List<Integer> key = new ArrayList<>(temp.keySet());
            Collections.sort(key, (o1, o2) -> temp.get(o2) - temp.get(o1));

            answer.add(key.get(0));
            if(key.size() > 1){
                answer.add(key.get(1));
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution42579 s = new Solution42579();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] play = {500, 600, 150, 800, 2500};
        s.solution(genres, play);
    }
//    public class Music implements Comparable<Music>{
//
//        private int played;
//        private int id;
//        private String genre;
//
//        public Music(String genre, int played, int id) {
//            this.genre = genre;
//            this.played = played;
//            this.id = id;
//        }
//
//        @Override
//        public int compareTo(Music other) {
//            if(this.played == other.played) return this.id - other.id;
//            return other.played - this.played;
//        }
//
//        public String getGenre() {return genre;}
//    }
//
//    public int[] solution(String[] genres, int[] plays) {
//        return IntStream.range(0, genres.length)
//                .mapToObj(i -> new Music(genres[i], plays[i], i))
//                .collect(Collectors.groupingBy(Music::getGenre))
//                .entrySet().stream()
//                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
//                .flatMap(x->x.getValue().stream().sorted().limit(2))
//                .mapToInt(x->x.id).toArray();
//    }
//
//    private int sum(List<Music> value) {
//        int answer = 0;
//        for (Music music : value) {
//            answer+=music.played;
//        }
//        return answer;
//    }
}
