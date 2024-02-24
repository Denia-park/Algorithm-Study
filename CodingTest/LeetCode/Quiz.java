package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.findAllPeople(6,
                BracketUtil.convertStrToIntArr(
                        "[[1,2,5],[2,3,8],[1,5,10]]"),
                1));
        System.out.println(solution.findAllPeople(4,
                BracketUtil.convertStrToIntArr(
                        "[[3,1,3],[1,2,2],[0,3,3]]"),
                3));
        System.out.println(solution.findAllPeople(5,
                BracketUtil.convertStrToIntArr(
                        "[[3,4,2],[1,2,1],[2,3,1]]"),
                1));
    }
}

class Solution {
    public List<Integer> findAllPeople(final int n, final int[][] meetings, final int firstPerson) {
        Arrays.sort(meetings, Comparator.comparingInt(v -> v[2]));

        //parents 초기화
        final int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        //처음에 비밀을 들은 사람
        parents[firstPerson] = 0;

        //유니온 - 파인드로 묶어줄 로직
        int idx = 0;
        final int size = meetings.length;
        final Set<Integer> listeners = new HashSet<>(n);
        while (idx < size) {
            final int time = meetings[idx][2];
            listeners.clear();

            //같은 시간인 애들은 한번에 다 계산을 해야함
            while (idx < size && time == meetings[idx][2]) {
                final int[] meeting = meetings[idx];
                final int parent0 = find(parents, meeting[0]);
                final int parent1 = find(parents, meeting[1]);
                if (parent0 != parent1) {//부모가 다르면
                    //유니온
                    parents[Math.max(parent0, parent1)] = Math.min(parent0, parent1);
                }
                listeners.add(meeting[0]);
                listeners.add(meeting[1]);
                idx++;
            }


            for (final Integer man : listeners) {
                final int parent = find(parents, man);
                //비밀을 못 들은 애들 -> 유니온을 푼다. (못 들었으니까)
                if (parent != 0) {
                    parents[man] = man;
                }
            }
        }

        //제대로 비밀을 아는 사람을 구할 로직 -> 부모 같은 데, 그 부모가 비밀을 알고 있으면 모두 다 비밀을 안다.
        final List<Integer> answer = new ArrayList<>(n);
        for (int man = 0; man < n; man++) {
            final int parent = find(parents, man);
            if (parent == 0) {
                answer.add(man);
            }
        }

        return answer;
    }

    private int find(final int[] groups, int index) {
        while (index != groups[index]) index = groups[index];
        return index;
    }
}
