import java.util.*;

class Solution {
    public void solution(String[] table) {
        Map<Character, Integer> changeTable = new HashMap<>();

        Arrays.sort(table, (a, b) -> -Integer.compare(a.length(), b.length()));

        for (String str : table) {
            int len = str.length();
            for (int i = 0; i < str.length(); i++) {
                char tempChar = str.charAt(i);

                int defaultScore = changeTable.getOrDefault(tempChar, -1);
                int addScore = (int) Math.pow(10, len);
                changeTable.put(tempChar, defaultScore + addScore);
                len--;
            }
        }

        List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(changeTable.entrySet());
        entryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int startValue = 9;
        for (Map.Entry<Character, Integer> ciEntry : entryList) {
            if (ciEntry.getValue() != 0) {
                changeTable.put(ciEntry.getKey(), startValue);
                startValue--;
            } else {
                changeTable.put(ciEntry.getKey(), 0);
            }
        }

        int result = 0;

        for (String str : table) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                char eachCh = str.charAt(i);
                sb.append(changeTable.get(eachCh));
            }

            result += Integer.parseInt(sb.toString());
        }

        System.out.println(result);
    }
}
