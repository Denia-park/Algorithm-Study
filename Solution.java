import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(String before, String after) {
        List<Character> beforeList = before.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> afterList = after.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        beforeList.sort(null);
        afterList.sort(null);

        if (afterList.equals(beforeList)) {
            return 1;
        } else {
            return 0;
        }
    }
}
