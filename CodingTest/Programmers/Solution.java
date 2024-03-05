package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(final int n, final int t, final int m, final String[] timetable) {
        //버스 출발 시간을 모두 구한다.
        final List<Integer> startList = makeStartList(hourToMin("09:00"), n, t);
        //크루원들의 도착 시간을 모두 구한다.
        final List<Integer> crew = makeCrewList(timetable);
        //크루원들의 도착 시간을 정렬한다.
        crew.sort(null);

        //어떤 크루원들까지 탔는지 구하기 위해 idx를 정의한다.
        int crewIdx = 0;
        //매번 버스에는 정원이 있으므로, 정원을 정의한다.
        int busLimit = m;

        //버스 출발 시간을 순회한다.
        for (final Integer startTime : startList) {
            //버스는 올 때마다 정원을 초기화한다.
            busLimit = m;

            //모든 크루원들이 아직 버스를 타지 않았고,
            //타야하는 크루원이 버스 출발 시간 전에 도착을 했으며,
            //버스의 정원이 남아있으면
            //버스를 탈 수 있다.
            while (crewIdx < crew.size()
                    && crew.get(crewIdx) <= startTime
                    && busLimit > 0) {
                crewIdx++; //타야하는 크루원의 idx 변경
                busLimit--; //버스 정원을 줄인다.
            }
        }

        //마지막 버스의 정원이 남아있으면, 해당 버스를 타면 된다.
        if (busLimit > 0) {
            final Integer lastBusStartTime = startList.get(startList.size() - 1);

            return minToHour(lastBusStartTime);
        } else {
            final Integer lastEnterCrewArriveTime = crew.get(crewIdx - 1);

            //마지막에 탄 크루원보다 1분만 빨리 도착하면, 버스를 탈 수 있다.
            return minToHour(lastEnterCrewArriveTime - 1);
        }
    }

    private List<Integer> makeStartList(final int startMin, final int n, final int t) {
        final List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(startMin + (t * i));
        }

        return list;
    }

    private int hourToMin(final String time) {
        final String[] split = time.split(":");
        return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
    }

    private String minToHour(final Integer time) {
        final int hour = time / 60;
        final int min = time % 60;

        return String.format("%02d:%02d", hour, min);
    }

    private List<Integer> makeCrewList(final String[] timetable) {
        final List<Integer> list = new ArrayList<>();
        for (final String str : timetable) {
            list.add(hourToMin(str));
        }

        return list;
    }
}
