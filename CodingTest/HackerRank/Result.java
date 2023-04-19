package CodingTest.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        List<String> newGrid = new ArrayList<>();

        //row - rearrange
        for (String str : grid) {
            char[] tempArr = str.toCharArray();
            Arrays.sort(tempArr);
            newGrid.add(String.valueOf(tempArr));
        }

        //check each colum while checking each row
        int colNum = newGrid.get(0).length();
        for (int col = 0; col < colNum; col++) {
            int rowNum = newGrid.size();
            char firstChar = newGrid.get(0).charAt(col);
            for (int row = 1; row < rowNum; row++) {
                char secondChar = newGrid.get(row).charAt(col);
                if (firstChar > secondChar) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}
