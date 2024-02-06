package CodingTest.Programmers;

//다른 유저에 대해서는 계속 신고 가능
//동일한 유저에 대해서는 1회만 처리

//k번 이상 신고되면 메일을 발송

import java.util.*;

//신고당한 유저가 정지가 되면, 신고한 사람은 메일을 받는 구조
//-> 신고할때 누가 신고했는지도 저장해야함
class Solution {
    public int[] solution(final String[] id_list, final String[] report, final int k) {
        final Map<String, Set<String>> reportMap = new HashMap<>();
        final Map<String, Integer> countMap = new HashMap<>();
        final Map<String, List<String>> resultMap = new HashMap<>();

        for (final String str : report) {
            final String[] split = str.split(" ");
            final String from = split[0];
            final String to = split[1];

            //신고한 사람이 동일한 사람을 신고하지 못하도록, Set에 넣어서 관리
            final Set<String> set = reportMap.getOrDefault(from, new HashSet<>());
            final boolean addResult = set.add(to);
            reportMap.put(from, set);

            //addResult에 따라 신고가 들어갔는지 판단 가능
            if (addResult) {
                countMap.put(to, countMap.getOrDefault(to, 0) + 1);

                //신고 대상이 신고되면 메일을 받아야 하므로, 따로 Map에서 관리
                final List<String> list = resultMap.getOrDefault(to, new ArrayList<>());
                list.add(from);
                resultMap.put(to, list);
            }
        }


        final Map<String, Integer> mailMap = new HashMap<>();

        //countMap을 돌면서, k번 이상이면 해당 유저들은 신고 처리됨
        //신고 처리된 유저들을 신고한 사람들도 메일을 받는다.
        countMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= k)
                .map(Map.Entry::getKey)
                .forEach(
                        name -> {
                            for (final String str : resultMap.get(name)) {
                                mailMap.put(str, mailMap.getOrDefault(str, 0) + 1);
                            }
                        }
                );

        return Arrays.stream(id_list)
                .mapToInt(id -> mailMap.getOrDefault(id, 0))
                .toArray();
    }
}
