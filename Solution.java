import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] food_times, long timeLimit) {
        PriorityQueue<Food> pq = new PriorityQueue<>();

        int totalFoodEatTime = 0;
        int idxCheck = 1;

        for (int food_time : food_times) {
            pq.add(new Food(idxCheck, food_time));
            totalFoodEatTime += food_time;
            idxCheck++;
        }

        if (totalFoodEatTime <= timeLimit) {
            return -1;
        }

        long time = 0;
        long timeWeight = 0;

        while (true) {
            int size = pq.size();
            Food minQuantityFood = pq.peek();

            long curSpandTime = (minQuantityFood.getFoodQuantity() - timeWeight) * size;

            if (time + curSpandTime > timeLimit) {
                break;
            }

            pq.poll();

            time += curSpandTime;

            timeWeight = minQuantityFood.getFoodQuantity();
        }

        List<Food> restFoods = pq.stream().sorted(Comparator.comparingInt(Food::getNumber)).collect(Collectors.toList());
        int size = restFoods.size();

        return restFoods.get((int) (timeLimit - time) % size).getNumber();
    }

}

class Food implements Comparable<Food> {
    int number;
    int foodQuantity;

    public Food(int number, int foodQuantity) {
        this.number = number;
        this.foodQuantity = foodQuantity;
    }

    public int getNumber() {
        return number;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    @Override
    public int compareTo(Food o) {
        return this.getFoodQuantity() - o.foodQuantity;
    }
}
