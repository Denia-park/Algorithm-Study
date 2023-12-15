package CodingTest.Programmers;

class Solution {
    public static final double CIRCLE_DEGREE = 360;

    public int solution(final int h1, final int m1, final int s1, final int h2, final int m2, final int s2) {
        int answer = 0;

        final double HOUR_DEGREE = CIRCLE_DEGREE / 12 / 60 / 60;
        final double MINUTE_DEGREE = CIRCLE_DEGREE / 60 / 60;
        final double SECOND_DEGREE = CIRCLE_DEGREE / 60;

        int startTimeSec = h1 * 60 * 60 + m1 * 60 + s1;
        final int endTimeSec = h2 * 60 * 60 + m2 * 60 + s2;

        double currentHourAngle = HOUR_DEGREE * startTimeSec % CIRCLE_DEGREE;
        double currentMinuteAngle = MINUTE_DEGREE * startTimeSec % CIRCLE_DEGREE;
        double currentSecondAngle = SECOND_DEGREE * startTimeSec % CIRCLE_DEGREE;
        double preSecondAngle = currentSecondAngle;

        int secPlusAmount = 0;

        while (startTimeSec <= endTimeSec) {
            if (isMatching(currentHourAngle, currentSecondAngle, preSecondAngle)
                    || isMatching(currentMinuteAngle, currentSecondAngle, preSecondAngle)) {
                answer++;
            }

            preSecondAngle = currentSecondAngle;
            currentSecondAngle = (currentSecondAngle + SECOND_DEGREE) % CIRCLE_DEGREE;

            if (secPlusAmount % 60 == 0) {
                currentMinuteAngle = (currentMinuteAngle + MINUTE_DEGREE) % CIRCLE_DEGREE;
            } else if (secPlusAmount % 3600 == 0) {
                currentHourAngle = (currentHourAngle + HOUR_DEGREE) % CIRCLE_DEGREE;
                secPlusAmount = 0;
            }

            startTimeSec++;
            secPlusAmount++;
        }

        return answer;
    }

    private boolean isMatching(final double currentAngle, final double currentSecondAngle, final double preSecondAngle) {
        return preSecondAngle <= currentAngle && currentAngle <= currentSecondAngle;
    }
}
