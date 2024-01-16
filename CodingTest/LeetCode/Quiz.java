package CodingTest.LeetCode;

import CodingTest.HackerRank.Solution;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println("1 : " + solution.findWinners(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]")));
//        System.out.println("2 : " + solution.findWinners(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[2,3],[1,3],[5,4],[6,4]]")));
    }
}

class RandomizedSet {
    final Random random = new Random();
    Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(final int val) {
        return set.add(val);
    }

    public boolean remove(final int val) {
        return set.remove(val);
    }

    public int getRandom() {
        final List<Integer> list = List.copyOf(set);

        return list.get((random.nextInt(list.size())));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
