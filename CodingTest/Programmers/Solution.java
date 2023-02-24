package CodingTest.Programmers;

class Solution {
    final int COFFEE_PRICE = 5500;

    public int[] solution(int money) {
        int[] answer = new int[2];

        answer[0] = money / COFFEE_PRICE;
        answer[1] = money % COFFEE_PRICE;

        return answer;
    }
}
