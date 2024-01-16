package CodingTest.LeetCode;

import CodingTest.HackerRank.Solution;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println("1 : " + solution.findWinners(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]")));
//        System.out.println("2 : " + solution.findWinners(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[2,3],[1,3],[5,4],[6,4]]")));
    }
}

class RandomizedSet {
    private final Random random = new Random();
    private final List<Integer> numList = new ArrayList<>();
    private final Map<Integer, Integer> numMap = new HashMap<>();

    public RandomizedSet() {
    }

    private boolean isExist(final int val) {
        //존재하는지 확인
        return numMap.containsKey(val);
    }

    public boolean insert(final int val) {
        //존재하면 false
        if (isExist(val)) {
            return false;
        }

        //존재하지 않으면 추가
        //numList에 마지막에 추가
        numList.add(val);
        //numMap에 추가
        //key : val, value : numList의 index
        numMap.put(val, numList.size() - 1);

        return true;
    }

    public boolean remove(final int val) {
        //존재하지 않으면 false
        if (!isExist(val)) {
            return false;
        }

        //존재하면 삭제
        //해당하는 val의 index를 가져온다.
        final int targetIdx = numMap.get(val);
        //마지막 값과 삭제할 값의 위치를 바꾼다. -> 쉽게 삭제하기 위해
        //바꾼다고 표현을 했지만 그냥 마지막 값을 삭제할 값의 위치에 덮어씌운다.
        numList.set(targetIdx, numList.get(numList.size() - 1));
        //numMap에도 Index를 바꾼다.
        numMap.put(numList.get(targetIdx), targetIdx);
        //마지막 값을 삭제한다.
        numList.remove(numList.size() - 1);
        //numMap에서 삭제한다.
        numMap.remove(val);

        return true;
    }

    public int getRandom() {
        //랜덤하게 값을 가져온다.
        final int randomIdx = random.nextInt(numList.size());

        return numList.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
