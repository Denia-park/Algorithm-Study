import java.util.Map;
import java.util.TreeMap;

class Solution {
    int gSize;
    String[] gTable;
    int answer;

    public int solution(int size, String[] table) {
        gSize = size;
        gTable = table;
        answer = 0;

        Map<Character, Integer> standardMap = new TreeMap<>();
        char[] defaultStr = table[0].toCharArray();
        for (char c : defaultStr) {
            standardMap.put(c, standardMap.getOrDefault(c, 0) + 1);
        }

        int diff = 0;

        for (int i = 1; i < size; i++) {
            Map<Character, Integer> diffMap = new TreeMap<>();

            char[] chars = gTable[i].toCharArray();
            for (char c : chars) {
                diffMap.put(c, diffMap.getOrDefault(c, 0) + 1);
            }

            for (Character c : diffMap.keySet()) {
                int tempCount = diffMap.get(c);
                int stanCount = standardMap.getOrDefault(c, -1);
                if (stanCount == -1) {
                    diff += tempCount;
                } else {
                    diff += tempCount - stanCount;
                }
            }

            if (diff <= 1) {
                answer++;
            }
        }

        return answer;
    }
}

