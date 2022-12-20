import java.util.HashMap;
import java.util.Map;

class Solution {
    public void solution(int candiNum, int nameLen, String[] table) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nameLen; i++) {
            Map<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < candiNum; j++) {
                char c = table[j].charAt(i);
                int count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
            }

            int defaultSize = sb.length();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= candiNum - 1) {
                    sb.append(entry.getKey());
                    break;
                }
            }

            if (sb.length() == defaultSize) {
                System.out.println("CALL FRIEND");
                return;
            }
        }

        System.out.println(sb);
    }
}
