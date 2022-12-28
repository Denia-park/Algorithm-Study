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

        for (int i = 1; i < size; i++) {
            Map<Character, Integer> tempMap = new TreeMap<>();
            int diff = 0;

            char[] chars = gTable[i].toCharArray();
            for (char c : chars) {
                tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
            }

            for (char c = 'A'; c <= 'Z'; c++) {
                diff += Math.abs(standardMap.getOrDefault(c, 0) - tempMap.getOrDefault(c, 0));
            }
            
            if (diff <= 1) {
                answer++;
            }
        }

        return answer;
    }
}

