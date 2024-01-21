package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] solution(final int[][] nodeinfo) {
        //이진 트리 만들기 전 정렬할 List
        final List<Point> preTreeList = new ArrayList<>();

        //Point 삽입
        final int length = nodeinfo.length;
        for (int i = 0; i < length; i++) {
            preTreeList.add(new Point((i + 1), nodeinfo[i][0], nodeinfo[i][1]));
        }

        //preTreeList 정렬 -> Y가 높은 순, x가 작은 순
        preTreeList.sort(
                Comparator.comparingInt((Point point) -> point.y).reversed()
                        .thenComparingInt((Point point) -> point.x)
        );

        final Point root = preTreeList.get(0);

        for (int i = 1; i < length; i++) {
            final Point curPoint = preTreeList.get(i);
            Point parent = root;

            while (true) {
                if (curPoint.x < parent.x) {
                    //왼쪽이 비어있으면 삽입
                    if (parent.left == null) {
                        parent.left = curPoint;
                        break;
                    }
                    //비어있지 않으면 왼쪽으로 이동
                    else {
                        parent = parent.left;
                    }
                } else {
                    //오른쪽이 비어있으면 삽입
                    if (parent.right == null) {
                        parent.right = curPoint;
                        break;
                    }
                    //비어있지 않으면 오른쪽으로 이동
                    else {
                        parent = parent.right;
                    }
                }
            }
        }

        //전위 순회
        final List<Integer> preOrders = new ArrayList<>();
        calculatePreOrderList(root, preOrders);

        //후위 순회
        final List<Integer> postOrders = new ArrayList<>();
        calculatePostOrderList(root, postOrders);

        return new int[][]{
                preOrders.stream().mapToInt(Integer::intValue).toArray(),
                postOrders.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    private void calculatePreOrderList(final Point root, final List<Integer> preOrders) {
        if (root == null) return;

        preOrders.add(root.number);
        calculatePreOrderList(root.left, preOrders);
        calculatePreOrderList(root.right, preOrders);
    }

    private void calculatePostOrderList(final Point root, final List<Integer> postOrders) {
        if (root == null) return;

        calculatePostOrderList(root.left, postOrders);
        calculatePostOrderList(root.right, postOrders);
        postOrders.add(root.number);
    }

    static class Point {
        int number;
        int x;
        int y;
        Point left;
        Point right;

        public Point(final int number, final int x, final int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }
}
