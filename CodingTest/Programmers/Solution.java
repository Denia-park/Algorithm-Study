package CodingTest.Programmers;

class Solution {
    public int[] solution(final int brown, final int yellow) {
        int[] answer = {};

        //y 높이로 가능한 숫자들을 돌리면서, 총 개수를 구해야 한다.
        //brown 개수 => 4 + 높이 * 2 + 너비 * 2

        final double minWidth = Math.sqrt(yellow);
        for (int width = yellow; width >= minWidth; width--) {
            final double height = (double) yellow / width;

            //정수가 아니면 넘어간다.
            if (height % 1 != 0) {
                continue;
            }

            final int intHeight = (int) height;
            final int tempBrown = 4 + intHeight * 2 + width * 2;

            if (tempBrown == brown) {
                answer = new int[]{width + 2, intHeight + 2};
                break;
            }
        }

        return answer;
    }
}
