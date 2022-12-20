import java.util.ArrayList;
import java.util.List;

class Solution {

    public void solution(int size, int[] table) {
        List<Integer> answerList = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            if (i == table[table[i]]) {
                answerList.add(i);
            }
        }
        
        System.out.println(answerList.size());
        for (Integer integer : answerList) {
            System.out.println(integer);
        }
    }
}
