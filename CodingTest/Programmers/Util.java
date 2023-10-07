package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static int[][] convertStringToJavaIntTwoDimensionalArray(String source) {
        String newString = source.substring(1, source.length() - 1);

        String[] intArrays = newString.replace("],[", "]&[").split("&");

        List<int[]> list = new ArrayList<>();

        for (String intArray : intArrays) {
            String tempString = intArray.substring(1, intArray.length() - 1);
            String[] tempStringArray = tempString.split(",");

            int[] tempIntArray = new int[tempStringArray.length];

            int idx = 0;
            for (String str : tempStringArray) {
                final String trimStr = str.trim();
                tempIntArray[idx] = Integer.parseInt(trimStr);
                idx++;
            }

            list.add(tempIntArray);
        }

        return list.toArray(new int[0][]);
    }
}
