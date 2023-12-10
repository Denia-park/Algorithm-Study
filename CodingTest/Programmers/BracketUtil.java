package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

public class BracketUtil {
    public static int[][] convertStringToJavaIntTwoDimensionalArray(final String source) {
        final String newString = source.substring(1, source.length() - 1);

        final String[] intArrays = newString.replace("], [", "]&[").replace("],[", "]&[").split("&");

        final List<int[]> list = new ArrayList<>();

        for (final String intArray : intArrays) {
            final String tempString = intArray.substring(1, intArray.length() - 1);
            final String[] tempStringArray = tempString.split(",");

            final int[] tempIntArray = new int[tempStringArray.length];

            int idx = 0;
            for (final String str : tempStringArray) {
                final String trimStr = str.trim();
                tempIntArray[idx] = Integer.parseInt(trimStr);
                idx++;
            }

            list.add(tempIntArray);
        }

        return list.toArray(new int[0][]);
    }
}
