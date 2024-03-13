package CodingTest.Programmers;

/*
1. 많이 재생된 장르 2가지를 고른다.
2. 해당 장르에서 제일 많이 재생된 노래를 고른다 (재생수가 같으면 고유번호 순)
 */

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(final String[] genres, final int[] plays) {
        //장르와 노래 재생 수를 저장
        final Map<String, Integer> genreMap = new HashMap<>();
        //장르와 노래를 저장
        final Map<String, List<Song>> genreSongMap = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            final String genre = genres[i];
            final int play = plays[i];

            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + play);

            genreSongMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, play));
        }

        //장르, 노래 Map을 정렬
        final List<String> topGenre = genreMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -1 * e.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        final List<Integer> answer = new ArrayList<>();

        int genreIdx = 0;
        while (genreIdx < topGenre.size()) {
            final var songs = genreSongMap.get(topGenre.get(genreIdx));
            songs.sort(Comparator.comparingInt((Song s) -> -1 * s.playCount).thenComparingInt(s -> s.idx));

            int idx = 0;
            while (idx < songs.size() && idx < 2) {
                answer.add(songs.get(idx).idx);
                idx++;
            }

            genreIdx++;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    static class Song {
        int idx;
        int playCount;

        public Song(final int idx, final int playCount) {
            this.idx = idx;
            this.playCount = playCount;
        }
    }
}
