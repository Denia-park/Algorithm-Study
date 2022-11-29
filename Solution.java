import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] food_times, long k) {
        int idxCheck = 1;

        Queue<Food> queue = new LinkedList<>();

        for (int food_time : food_times) {
            queue.add(new Food(idxCheck, food_time));
            idxCheck++;
        }
        long time = 0;

        while (time < k) {
            if (!queue.isEmpty()) {
                Food food = queue.poll();

                food.eat();

                if (food.getFoodQuantity() > 0) {
                    queue.add(food);
                }
            }

            time++;
        }

        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.peek().getNumber();
        }
    }

}

class Food {
    int number;
    int foodQuantity;

    public Food(int number, int foodQuantity) {
        this.number = number;
        this.foodQuantity = foodQuantity;
    }

    void eat() {
        this.foodQuantity--;
    }

    public int getNumber() {
        return number;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }
}
