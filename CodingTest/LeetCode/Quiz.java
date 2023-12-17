package CodingTest.LeetCode;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        solution.solution();
    }
}

class Solution {
    public void solution() {
        final FoodRatings foodRatings = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7}
        );

        System.out.println((foodRatings.highestRated("korean"))); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.

        System.out.println((foodRatings.highestRated("japanese"))); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.

        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.

        System.out.println((foodRatings.highestRated("japanese"))); // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.

        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.

        System.out.println((foodRatings.highestRated("japanese"))); // return "ramen"
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".

    }
}

class FoodRatings {

    private static final Comparator<Food> FOOD_COMPARATOR = Comparator.comparingInt(Food::getRating).reversed().thenComparing(Food::getName);
    private final Map<String, List<Food>> cuisineFoodMap;
    private final Map<String, Food> foodMap;

    public FoodRatings(final String[] foods, final String[] cuisines, final int[] ratings) {
        cuisineFoodMap = new HashMap<>();
        foodMap = new HashMap<>();

        for (int i = 0; i < ratings.length; i++) {
            final String tempFood = foods[i];
            final String tempCuisine = cuisines[i];
            final int tempRating = ratings[i];

            final Food food = new Food(tempFood, tempCuisine, tempRating);


            final List<Food> foodList = cuisineFoodMap.getOrDefault(tempCuisine, new ArrayList<>());
            foodList.add(food);
            cuisineFoodMap.put(tempCuisine, foodList);
            foodMap.put(tempFood, food);
        }

        for (final List<Food> foodList : cuisineFoodMap.values()) {
            foodList.sort(FOOD_COMPARATOR);
        }
    }

    public void changeRating(final String foodName, final int newRating) {
        final Food food = foodMap.get(foodName);
        food.setRating(newRating);

        final List<Food> foodList = cuisineFoodMap.get(food.getCuisine());
        foodList.sort(FOOD_COMPARATOR);
    }

    public String highestRated(final String cuisine) {
        final List<Food> foodList = cuisineFoodMap.get(cuisine);
        System.out.println(foodList);
        return foodList.get(0).getName();
    }
}

class Food {
    private final String name;
    private final String cuisine;
    private int rating;

    public Food(final String name, final String cuisine, final int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }
}
