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
            final int[] ints = nodeinfo[i];
            final int x = ints[0];
            final int y = ints[1];

            preTreeList.add(new Point(i + 1, x, y));
        }

        //preTreeList 정렬 -> Y가 높은 순, x가 작은 순
        preTreeList.sort(Comparator.comparingInt(Point::getY).reversed().thenComparingInt(Point::getX));

        //높이 따라 List로 Point 정리하기
        final List<List<Point>> heightSortedPoints = new ArrayList<>();

        int curHeight = preTreeList.get(0).y;
        List<Point> tempList = new ArrayList<>();
        for (final Point point : preTreeList) {
            if (curHeight == point.getY()) {
                tempList.add(point);
            } else {
                heightSortedPoints.add(tempList);
                tempList = new ArrayList<>();

                tempList.add(point);
                curHeight = point.getY();
            }
        }

        //남은 List 추가하기
        heightSortedPoints.add(tempList);

        final List<Point> points = heightSortedPoints.get(0);
        final Point root = points.get(0);

        for (int curChildIdx = 1; curChildIdx < heightSortedPoints.size(); curChildIdx++) {
            //추가해야 하는 자식 List
            final List<Point> childList = heightSortedPoints.get(curChildIdx);

            for (final Point child : childList) {
                final int x = child.x;
                Point curPoint = root;
                while (true) {
                    if (curPoint.left != null && x < curPoint.x) {
                        curPoint = curPoint.left;
                    } else if (x < curPoint.x) {
                        curPoint.left = child;
                        break;
                    } else if (curPoint.right != null && x > curPoint.x) {
                        curPoint = curPoint.right;
                    } else {
                        curPoint.right = child;
                        break;
                    }
                }
            }
        }

        //전위 순회
        final List<Integer> preOrders = new ArrayList<>();
        calculatePreOrderList(root, preOrders);

        final int[] preOrderInts = new int[length];
        for (int i = 0; i < length; i++) {
            preOrderInts[i] = preOrders.get(i);
        }

        //후위 순회
        final List<Integer> postOrders = new ArrayList<>();
        calculateetPostOrderList(root, postOrders);

        final int[] postOrderInts = new int[length];
        for (int i = 0; i < length; i++) {
            postOrderInts[i] = postOrders.get(i);
        }

        return new int[][]{
                preOrderInts,
                postOrderInts
        };
    }

    private void calculatePreOrderList(final Point root, final List<Integer> preOrders) {
        if (root == null) {
            return;
        }

        preOrders.add(root.number);

        calculatePreOrderList(root.left, preOrders);

        calculatePreOrderList(root.right, preOrders);
    }

    private void calculateetPostOrderList(final Point root, final List<Integer> postOrders) {
        if (root == null) {
            return;
        }

        calculateetPostOrderList(root.left, postOrders);

        calculateetPostOrderList(root.right, postOrders);

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

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "number=" + number +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
