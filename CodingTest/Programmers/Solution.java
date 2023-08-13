package CodingTest.Programmers;

/*

아이디어
1. 모든 경우의 수를 돌면서 경로 탐색 -> 완전 탐색 [dfs 이용]

시간복잡도
목적지 수 가진 만큼의 거듭 제곱

자료구조
dfs -> deque

 */

import java.util.*;

class Solution {
    Deque<String> ticketDeque;
    private String START_DEPARTURE = "ICN";
    private List<List<String>> answer = new ArrayList<>();
    private Map<String, List<Ticket>> map = new HashMap<>();
    private int ticketCount = 0;

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        map = new HashMap<>();
        ticketCount = tickets.length;
        ticketDeque = new ArrayDeque<>();
        ticketDeque.add(START_DEPARTURE);

        for (String[] ticket : tickets) {
            final String departure = ticket[0];
            final String arrival = ticket[1];

            //검색해서 List가 존재하면 거기에 추가, 없으면 새로 생성
            final List<Ticket> arrivalList = map.getOrDefault(departure, new ArrayList<>());
            arrivalList.add(new Ticket(arrival));
            map.put(departure, arrivalList);
        }

        dfs(START_DEPARTURE, ticketDeque);

        answer.sort((o1, o2) -> {
            for (int idx = 0; idx < o1.size(); idx++) {
                final String s1 = o1.get(idx);
                final String s2 = o2.get(idx);

                if (s1.compareTo(s2) != 0) {
                    return s1.compareTo(s2);
                }
            }
            return 0;
        });

        return answer.get(0).toArray(new String[]{});
    }

    private void dfs(String departure, Deque<String> ticketDeque) {
        if (ticketDeque.size() == ticketCount + 1) {
            answer.add(new ArrayList<>(ticketDeque));
            return;
        }

        final List<Ticket> arrivals = map.get(departure);
        if (arrivals == null) {
            return;
        }

        for (final Ticket ticket : arrivals) {
            final String arrival = ticket.arrival;
            final boolean visited = ticket.visited;

            if (visited) {
                continue;
            }

            ticket.visited = true;
            ticketDeque.addLast(arrival);
            dfs(arrival, ticketDeque);
            ticket.visited = false;
            ticketDeque.removeLast();
        }
    }

    class Ticket {
        String arrival;
        boolean visited;

        public Ticket(final String arrival) {
            this.arrival = arrival;
        }
    }
}
