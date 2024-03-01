package CodingTest.Programmers;

class Solution {
    public int solution(final int n, final int[] cores) {
        if (n <= cores.length) {
            return n;
        }

        final int restWork = n - cores.length;

        long minTime = Long.MAX_VALUE;

        //이분 탐색을 통해 모두 처리가 가능한 시간을 구하자
        long l = 1;
        long r = 10000L * (restWork / cores.length);
        while (l <= r) {
            final long mid = l + ((r - l) / 2);

            final int work = calculate(mid, cores);

            if (work >= restWork) {
                minTime = Math.min(minTime, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        final int finishedWork = calculate(minTime - 1, cores);
        int lastRestWork = restWork - finishedWork;

        int idx = 0;
        while (lastRestWork > 0) {
            if (minTime % cores[idx] == 0) {
                lastRestWork--;
            }
            idx++;
        }

        return idx;
    }

    private int calculate(final long mid, final int[] cores) {
        int count = 0;

        for (final int core : cores) {
            count += (int) (mid / core);
        }

        return count;
    }
}
