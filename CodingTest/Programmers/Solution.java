package CodingTest.Programmers;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<String, Integer> foodCountMap;

    public String[] solution(final String[] orders, final int[] course) {
        foodCountMap = new HashMap<>();
        final List<Integer> courseList = Arrays.stream(course).boxed().collect(Collectors.toList());

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

        //글자 수에 따라 분배를 하고, 정렬을 해서 가장 많이 주문한 조합을 구한다.
        final Map<Integer, List<String>> collect = foodCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .collect(Collectors.groupingBy(entry -> entry.getKey().length(), Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        for (final Map.Entry<Integer, List<String>> entry : collect.entrySet()) {
            final List<String> strings = entry.getValue();
            strings.sort((o1, o2) -> foodCountMap.get(o2) - foodCountMap.get(o1));
        }

        final List<String> answer = new ArrayList<>();

        //answer를 정렬하고, return한다.
        for (final Map.Entry<Integer, List<String>> entry : collect.entrySet()) {
            final int combiCount = entry.getKey();
            final List<String> strings = entry.getValue();
            final int maxValue = foodCountMap.get(strings.get(0));

            if (!courseList.contains(combiCount)) {
                continue;
            }

            for (final String string : strings) {
                if (foodCountMap.get(string) == maxValue) {
                    answer.add(string);
                } else {
                    break;
                }
            }
        }

        answer.sort(null);

        return answer.toArray(new String[0]);
    }

    private void combination(final String[] foods, final int limit, final int curIdx, final String curFoodCombination) {
        if (curFoodCombination.length() == limit) {
            //map에 저장한다.
            foodCountMap.put(curFoodCombination, foodCountMap.getOrDefault(curFoodCombination, 0) + 1);
            return;
        }

        //2개부터 foods.length개까지 조합을 구한다.
        for (int addIdx = curIdx; addIdx < foods.length; addIdx++) {
            final String curFood = foods[addIdx];

            combination(foods, limit, addIdx + 1, curFoodCombination + curFood);
        }
    }
}
