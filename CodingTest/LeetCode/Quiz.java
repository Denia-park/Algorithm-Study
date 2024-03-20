package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(
//                solution.mergeInBetween(
//                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'},
//                        2
//                )
//        );
    }
}

class Solution {
    public ListNode mergeInBetween(final ListNode list1, final int a, final int b, final ListNode list2) {
        int idx = 0;

        ListNode putStart = null;
        ListNode putEnd = null;

        ListNode search = list1;
        while (search != null) {
            if (idx == a - 1) {
                putStart = search;
            } else if (idx == b + 1) {
                putEnd = search;
            }

            search = search.next;
            idx++;
        }

        putStart.next = list2;

        search = list2;
        while (search.next != null) {
            search = search.next;
        }

        search.next = putEnd;

        return list1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(final int val) {
        this.val = val;
    }

    ListNode(final int val, final ListNode next) {
        this.val = val;
        this.next = next;
    }
}
