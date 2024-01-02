package CodingTest.Programmers;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<String, Integer> foodCountMap;
    Map<Integer, Set<String>> nameLengthMap;

    public String[] solution(final String[] orders, final int[] course) {
        foodCountMap = new HashMap<>();
        nameLengthMap = new HashMap<>();

        //orders를 기반으로 모든 조합들을 구한다. -> Map에 메뉴 이름을 기준으로 개수를 count한다.
        for (final String order : orders) {
            //split 한다.
            final String[] foods = order.split("");

            //정렬 한다.
            Arrays.sort(foods);

            //모든 조합들을 map에 저장한다. (최소 조합이 2개)
            for (int combiLimit = 2; combiLimit <= foods.length; combiLimit++) {
                combination(foods, combiLimit, 0, "");
            }
        }

        final Set<String> answer = new TreeSet<>();

        //course를 기준으로 가장 많이 주문한 조합을 구한다.
        for (final int courseNum : course) {
            final Set<String> strings = nameLengthMap.get(courseNum);

            if (strings == null) {
                continue;
            }

            final List<String> sortedFoods = strings.stream()
                    .sorted((o1, o2) -> foodCountMap.get(o2) - foodCountMap.get(o1))
                    .collect(Collectors.toList());

            final int maxValue = foodCountMap.get(sortedFoods.get(0));

            if (maxValue < 2) {
                continue;
            }

            for (final String string : sortedFoods) {
                if (foodCountMap.get(string) != maxValue) {
                    break;
                }

                answer.add(string);
            }
        }

        return answer.toArray(String[]::new);
    }

    private void combination(final String[] foods, final int limit, final int curIdx, final String curFoodCombination) {
        if (curFoodCombination.length() == limit) {
            //map에 저장한다.
            foodCountMap.put(curFoodCombination, foodCountMap.getOrDefault(curFoodCombination, 0) + 1);

            //길이에 따라 저장한다.
            final Set<String> set = nameLengthMap.getOrDefault(limit, new HashSet<>());
            set.add(curFoodCombination);
            nameLengthMap.put(limit, set);
            return;
        }

        //2개부터 foods.length개까지 조합을 구한다.
        for (int addIdx = curIdx; addIdx < foods.length; addIdx++) {
            final String curFood = foods[addIdx];

            combination(foods, limit, addIdx + 1, curFoodCombination + curFood);
        }
    }
}
