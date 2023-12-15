package CodingTest.Programmers;

import java.util.List;

class Solution {
    public int solution(final int h1, final int m1, final int s1, final int h2, final int m2, final int s2) {
        int answer = 0;

        // 시작 시간과, 종료 시간을 초 단위로 변경
        final int start = new Time(h1, m1, s1).toSeconds();
        final int end = new Time(h2, m2, s2).toSeconds();

        // 시작 시간부터 1초씩 올려가며 계산(마지막 초는 포함되면 안됨)
        // 마지막 초기 포함되면 마지막 초 + 1까지 판단해버림
        for (int i = start; i < end; i++) {
            // 현재 시간이 i초일 때의
            final List<Double> cnt = new Time(i).getDegree();
            final List<Double> next = new Time(i + 1).getDegree();

            final boolean hMatch = hourMatch(cnt, next);
            final boolean mMatch = minuteMatch(cnt, next);

            // 초침이 분침과 시침과 겹침이 발생했을 때,
            if (hMatch && mMatch) {
                // 시침과 분침의 각도가 같다면 +1만 해줘야함
                if (Double.compare(next.get(0), next.get(1)) == 0) answer++;
                    // 아니라면 +2
                else answer += 2;
            }
            // 둘 중 하나라도 겹치면 +1
            else if (hMatch || mMatch) answer++;
        }

        // 위 로직은 시작시간에 대한 검사를 안해줬음
        // 그래서 0시 또는 12시에 시작한다면, 한번 겹치고 시작하는 것이기 때문에 +1
        if (start == 0 || start == 43200) answer++;
        return answer;
    }

    // 시침가 초침의 겹침을 판단
    boolean hourMatch(final List<Double> cnt, final List<Double> next) {
        if (Double.compare(cnt.get(0), cnt.get(2)) > 0
                && Double.compare(next.get(0), next.get(2)) <= 0) {
            return true;
        }
        // 초침이 354도에서 0도로 넘어갈 때 예외 케이스
        return Double.compare(cnt.get(2), 354d) == 0
                && Double.compare(cnt.get(0), 354d) > 0;
    }

    // 분침과 초침의 겹침을 판단
    boolean minuteMatch(final List<Double> cnt, final List<Double> next) {
        if (Double.compare(cnt.get(1), cnt.get(2)) > 0
                && Double.compare(next.get(1), next.get(2)) <= 0) {
            return true;
        }
        // 초침이 354도에서 0도로 넘어갈 때 예외 케이스
        return Double.compare(cnt.get(2), 354d) == 0
                && Double.compare(cnt.get(1), 354d) > 0;
    }
}

// 각 시간과 시간과 관련된 로직을 가지는 Time 클래스 정의
class Time {
    int h;
    int m;
    int s;

    public Time(final int h, final int m, final int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    // 초로 변환된 시간을 가지고도 Time을 만들 수 있도록 생성자 정의
    public Time(final int seconds) {
        this.h = seconds / 3600;
        this.m = (seconds % 3600) / 60;
        this.s = (seconds % 3600) % 60;
    }

    // 모든 시간을 초로 변환
    public int toSeconds() {
        return h * 3600 + m * 60 + s;
    }

    // 각도를 계산해서 List 형태로 반환
    List<Double> getDegree() {
        final Double hDegree = (h % 12) * 30d + m * 0.5d + s * (1 / 120d);
        final Double mDegree = m * 6d + s * (0.1d);
        final Double sDegree = s * 6d;

        return List.of(hDegree, mDegree, sDegree);
    }
}
