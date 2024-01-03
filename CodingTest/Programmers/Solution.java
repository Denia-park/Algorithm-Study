package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
언어는 cpp, java, python, - 중 하나입니다.
직군은 backend, frontend, - 중 하나입니다.
경력은 junior, senior, - 중 하나입니다.
소울푸드는 chicken, pizza, - 중 하나입니다.
 */

class Solution {
    public int[] solution(final String[] info, final String[] query) {
        final int[] answer = {};
        final List<Language> languages = new ArrayList<>();

        for (final String infoString : info) {
            final String[] infoArray = infoString.split(" ");

            final Language language = new Language(infoArray[0]);
            final Position position = language.positions.stream()
                    .filter(p -> p.name.equals(infoArray[1]))
                    .findFirst().get();
            final Career career = position.careers.stream()
                    .filter(c -> c.name.equals(infoArray[2]))
                    .findFirst().get();
            final SoulFood soulFood = career.soulFoods.stream()
                    .filter(s -> s.name.equals(infoArray[3]))
                    .findFirst().get();

            soulFood.addScore(Integer.parseInt(infoArray[4]));

            languages.add(language);
        }

        final List<Integer> answerList = new ArrayList<>();

        for (final String queryString : query) {
            final String[] split = queryString.replace("and ", "").split(" ");
            final String languageName = split[0];
            final String positionName = split[1];
            final String careerName = split[2];
            final String soulFoodName = split[3];
            final int targetScore = Integer.parseInt(split[4]);

            final List<Language> filteredLanguages = languages.stream()
                    .filter(lang -> lang.name.equals(languageName) || languageName.equals("-"))
                    .collect(Collectors.toList());

            final List<Position> filteredPositions = filteredLanguages.stream()
                    .flatMap(lang -> lang.positions.stream())
                    .filter(pos -> pos.name.equals(positionName) || positionName.equals("-"))
                    .collect(Collectors.toList());

            final List<Career> filteredCareers = filteredPositions.stream()
                    .flatMap(pos -> pos.careers.stream())
                    .filter(career -> career.name.equals(careerName) || careerName.equals("-"))
                    .collect(Collectors.toList());

            final List<SoulFood> filteredSoulFoods = filteredCareers.stream()
                    .flatMap(career -> career.soulFoods.stream())
                    .filter(soulFood -> soulFood.name.equals(soulFoodName) || soulFoodName.equals("-"))
                    .collect(Collectors.toList());

            final int sum = filteredSoulFoods.stream()
                    .mapToInt(value -> value.countScore(targetScore))
                    .sum();

            answerList.add(sum);
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Language {
        String name;
        List<Position> positions = List.of(new Position("backend"), new Position("frontend"));

        Language(final String name) {
            this.name = name;
        }
    }

    static class Position {
        String name;
        List<Career> careers = List.of(new Career("junior"), new Career("senior"));

        Position(final String name) {
            this.name = name;
        }
    }

    static class Career {
        String name;
        List<SoulFood> soulFoods = List.of(new SoulFood("chicken"), new SoulFood("pizza"));

        Career(final String name) {
            this.name = name;
        }
    }

    static class SoulFood {
        String name;
        List<Integer> scores;

        SoulFood(final String name) {
            this.name = name;
            scores = new ArrayList<>();
        }

        void addScore(final int score) {
            scores.add(score);
        }

        int countScore(final int targetScore) {
            int count = 0;

            for (final Integer score : scores) {
                if (score >= targetScore) {
                    count++;
                }
            }

            return count;
        }
    }
}

