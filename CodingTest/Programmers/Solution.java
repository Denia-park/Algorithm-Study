package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(final int n, final int t, final int m, final String[] timetable) {
        final List<Integer> startList = makeStartList(hourToMin("09:00"), n, t);

        final List<Integer> crew = makeCrewList(timetable);

        int idx = 0;
        int busLimit = m;

        for (final Integer startTime : startList) {
            busLimit = m;

            while (idx < crew.size() && crew.get(idx) <= startTime && busLimit > 0) {
                idx++;
                busLimit--;
            }
        }

        if (busLimit > 0) {
            return minToHour(startList.get(startList.size() - 1));
        } else {
            return minToHour(crew.get(idx - 1) - 1);
        }
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
        list.sort(null);

        return list;
    }

    private int hourToMin(final String time) {
        final String[] split = time.split(":");
        return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
    }

    private List<Integer> makeStartList(final int startMin, final int n, final int t) {
        final List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(startMin + (t * i));
        }

        return list;
    }
}
