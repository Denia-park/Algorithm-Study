package CodingTest.Programmers;

/*
2021 카카오 채용연계형 인턴십 - 표 편집

아이디어
- 구현 , 배열 사용하고 배열은 고정, value만 값을 바꿔가면서 사용
- Z는 스택을 사용하자.

시간 복잡도
- 단순 구현말고는 일단은 더 나은 방법을 모르겠음 ..

자료 구조
- boolen[] , Stack<Integer> 로 처리

 */

import java.util.Stack;

class Solution {
    public String solution(int totalNum, int curSel, String[] cmd) {
        Stack<Node> stack = new Stack<>();

        Node curNode = null;
        Node headNode = null;
        Node lastNode = null;

        for (int i = 0; i < totalNum; i++) {
            Node newNode = new Node(i);

            if (i == curSel) {
                curNode = newNode;
            }

            if (headNode == null) {
                headNode = newNode;
            } else {
                lastNode.add(newNode);
            }
            lastNode = newNode;
        }

        for (String comm : cmd) {
            String[] splits = comm.split(" ");

            String alpha = splits[0];

            int count = 0;

            if (alpha.equals("U")) {
                int moveCount = Integer.parseInt(splits[1]);
                while (moveCount != count) {
                    count++;

                    if (curNode != null && curNode.prev != null)
                        curNode = curNode.prev;
                }
            } else if (alpha.equals("D")) {
                int moveCount = Integer.parseInt(splits[1]);
                while (moveCount != count) {
                    count++;

                    if (curNode != null && curNode.next != null)
                        curNode = curNode.next;
                }
            } else if (alpha.equals("C")) {
                Node nextNode = curNode.next;
                if (nextNode == null) {
                    nextNode = curNode.prev;
                }

                stack.push(curNode.remove());
                if (curNode == headNode) {
                    headNode = nextNode;
                }
                curNode = nextNode;
            } else if (alpha.equals("Z")) {
                Node restoreNode = stack.pop();
                restoreNode.restore();
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (headNode != null) {
            if (count == headNode.idx) {
                count++;
                headNode = headNode.next;
                sb.append("O");
            } else {
                count++;
                sb.append("X");
            }
        }

        return sb.toString();
    }

    class Node {
        int idx;
        Node next;
        Node prev;

        public Node(int idx) {
            this.idx = idx;
        }

        public void add(Node node) {
            next = node;
            node.prev = this;
        }

        public Node remove() {
            Node prevNode = this.prev;
            Node nextNode = this.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            return this;
        }

        public void restore() {
            Node prevNode = this.prev;
            Node nextNode = this.next;

            prevNode.next = this;
            nextNode.prev = this;
        }
    }
}
