package CodingTest.Programmers;

import java.util.*;

class Solution {

    //방향 배열 설정
    final int[][] directions = new int[][]{
            {-1, 0},
            {-1, 1},
            {0, 1},
            {1, 1},
            {1, 0},
            {1, -1},
            {0, -1},
            {-1, -1}
    };

    public int solution(final int[] arrows) {
        int answer = 0;

        //시작 노드
        Node curNode = new Node(0, 0);

        //방문 여부 관련 선언
        //key = 시작 노드, value = 연결 노드
        final Map<Node, Set<Node>> visited = new HashMap<>();

        for (final int arrow : arrows) {
            //교차점 처리를 위한 스케일 업
            for (int count = 0; count < 2; count++) {
                final Node nextNode = new Node(
                        curNode.row + directions[arrow][0],
                        curNode.col + directions[arrow][1]
                );

                //처음 방문하는 경우 => map에 키 값이 없는 경우
                if (!visited.containsKey(nextNode)) {
                    //리스트에 연결되었다고 표시 (리스트에 값 추가)
                    visited.put(nextNode, makeNewSet(curNode));

                    if (visited.containsKey(curNode)) {
                        visited.get(curNode).add(nextNode);
                    } else {
                        visited.put(curNode, makeNewSet(nextNode));
                    }
                }

                //해당 노드에 이미 방문했고, 간선을 처음 통과하는 경우
                else if (!visited.get(nextNode).contains(curNode)) {
                    visited.get(nextNode).add(curNode);
                    visited.get(curNode).add(nextNode);

                    answer++;
                }

                //방에 대한 처리를 했으므로
                //점을 이동시켜야 함
                curNode = nextNode;
            }
        }

        return answer;
    }

    private Set<Node> makeNewSet(final Node nextNode) {
        final Set<Node> returnList = new HashSet<>();

        returnList.add(nextNode);

        return returnList;
    }

    static class Node {
        int row;
        int col;

        Node(final int row, final int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Node node = (Node) o;
            return row == node.row && col == node.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
