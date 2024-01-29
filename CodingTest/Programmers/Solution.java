package CodingTest.Programmers;

class Solution {
    int[][] coordiPos = {
            {3, 1}, //0
            {0, 0}, //1
            {0, 1}, //2
            {0, 2}, //3
            {1, 0}, //4
            {1, 1}, //5
            {1, 2}, //6
            {2, 0}, //7
            {2, 1}, //8
            {2, 2}  //9
    };
    private String myHand;

    public String solution(final int[] numbers, final String hand) {
        final StringBuilder sb = new StringBuilder();
        myHand = hand.equals("left") ? "L" : "R";

        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};

        for (final int number : numbers) {
            final String value = check(number, left, right);

            if (value.equals("L")) {
                left = coordiPos[number];
            } else {
                right = coordiPos[number];
            }

            sb.append(value);
        }

        return sb.toString();
    }

    private String check(final int number, final int[] left, final int[] right) {
        if (number == 1 || number == 4 || number == 7) {
            return "L";
        } else if (number == 3 || number == 6 || number == 9) {
            return "R";
        }

        final int[] numberCoordi = coordiPos[number];

        final int leftDistance = Math.abs(numberCoordi[0] - left[0]) + Math.abs(numberCoordi[1] - left[1]);
        final int rightDistance = Math.abs(numberCoordi[0] - right[0]) + Math.abs(numberCoordi[1] - right[1]);

        //왼쪽이 가까우면 왼손
        if (leftDistance < rightDistance) {
            return "L";
        }

        //오른손이 가까우면 오른손
        if (leftDistance > rightDistance) {
            return "R";
        }

        //같으면 myHand
        return myHand;
    }
}
