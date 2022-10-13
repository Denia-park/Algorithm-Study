import java.util.stream.IntStream;

class Solution {
    public Integer[] solution(int[] numlist, int n) {

        return IntStream.of(numlist).boxed().sorted((o1, o2) -> {
            int o1Abs = Math.abs(o1 - n);
            int o2Abs = Math.abs(o2 - n);

            if (o1Abs == o2Abs) {
                if (o1 > o2) return -1;
                else if (o1 < o2) return 1;
            } else {
                return o1Abs - o2Abs;
            }

            return 0;
        }).toArray(Integer[]::new);
    }
}
