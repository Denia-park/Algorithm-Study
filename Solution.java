import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();

        char temp_char = 'a';
        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(temp_char));
            temp_char++;
        }

        String ageStr = String.valueOf(age);

        for (int i = 0; i < ageStr.length(); i++) {
            answer.append(map.get(ageStr.charAt(i) - '0'));
        }
        return answer.toString();
    }
}
