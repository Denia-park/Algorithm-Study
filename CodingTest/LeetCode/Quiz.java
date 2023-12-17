package CodingTest.LeetCode;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(new Food("abc", "B", 1).equals(new Food("abc", "B", 2)));

        solution.solution();
    }
}

class Solution {
    public void solution() {
        final FoodRatings foodRatings = new FoodRatings(
                new String[]{"emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq"},
                new String[]{"snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"},
                new int[]{2, 6, 18, 6, 5}
        );

        foodRatings.changeRating("qnvseohnoe", 11);
        System.out.println((foodRatings.highestRated("fajbervsj")));
        foodRatings.changeRating("emgqdbo", 3);
        foodRatings.changeRating("jmvfxjohq", 9);
        foodRatings.changeRating("emgqdbo", 14);
        System.out.println((foodRatings.highestRated("fajbervsj")));
        System.out.println((foodRatings.highestRated("snaxol")));
    }
}

class FoodRatings {
    private static final Comparator<Food> FOOD_COMPARATOR = Comparator.comparingInt(Food::getRating).reversed().thenComparing(Food::getName);
    private final Map<String, TreeSet<Food>> cuisineFoodMap;
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

            final TreeSet<Food> set = cuisineFoodMap.getOrDefault(tempCuisine, new TreeSet<>(FOOD_COMPARATOR));
            set.add(food);
            cuisineFoodMap.put(tempCuisine, set);

            foodCuisineMap.put(tempFood, tempCuisine);
            foodRatingMap.put(tempFood, tempRating);
        }
    }

    public void changeRating(final String foodName, final int newRating) {
        final String cuisineName = foodCuisineMap.get(foodName);
        final TreeSet<Food> set = cuisineFoodMap.get(cuisineName);

        set.remove(new Food(foodName, cuisineName, foodRatingMap.get(foodName)));

        set.add(new Food(foodName, cuisineName, newRating));
        foodRatingMap.put(foodName, newRating);
    }

    public String highestRated(final String cuisine) {
        final TreeSet<Food> set = cuisineFoodMap.get(cuisine);

        return set.first().getName();
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
