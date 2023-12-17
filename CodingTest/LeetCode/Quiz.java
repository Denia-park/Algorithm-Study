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
    private final Map<String, PriorityQueue<Food>> cuisineFoodMap;
    private final Map<String, String> foodCuisineMap;
    private final Map<String, Integer> foodRatingMap;

    public FoodRatings(final String[] foods, final String[] cuisines, final int[] ratings) {
        cuisineFoodMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        foodRatingMap = new HashMap<>();

        for (int i = 0; i < ratings.length; i++) {
            final String tempFood = foods[i];
            final String tempCuisine = cuisines[i];
            final int tempRating = ratings[i];

            final Food food = new Food(tempFood, tempCuisine, tempRating);


            final PriorityQueue<Food> priorityQueue = cuisineFoodMap.getOrDefault(tempCuisine, new PriorityQueue<>(FOOD_COMPARATOR));
            priorityQueue.add(food);
            cuisineFoodMap.put(tempCuisine, priorityQueue);

            foodCuisineMap.put(tempFood, tempCuisine);
            foodRatingMap.put(tempFood, tempRating);
        }
    }

    public void changeRating(final String foodName, final int newRating) {
        foodRatingMap.put(foodName, newRating);

        final String cuisineName = foodCuisineMap.get(foodName);
        final PriorityQueue<Food> priorityQueue = cuisineFoodMap.get(cuisineName);
        final Food food = new Food(foodName, cuisineName, newRating);
        priorityQueue.add(food);

        Food highestFood = priorityQueue.peek();

        while (foodRatingMap.get(highestFood.getName()) != highestFood.getRating()) {
            priorityQueue.poll();
            highestFood = priorityQueue.peek();
        }
    }

    public String highestRated(final String cuisine) {
        final PriorityQueue<Food> priorityQueue = cuisineFoodMap.get(cuisine);

        final Food food = priorityQueue.peek();

        return food.getName();
    }
}

class Food {
    private final String name;
    private final String cuisine;
    private final int rating;

    public Food(final String name, final String cuisine, final int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Food food = (Food) o;
        return Objects.equals(getName(), food.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
