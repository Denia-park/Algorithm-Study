package CodingTest.Programmers;

class Solution {
    public static String timeConversion(String s) {
        // Write your code here
        String time = s.substring(0, s.length() - 2);
        String hourType = s.substring(s.length() - 2, s.length());
        if (hourType.equals("AM")) {
            if (time.substring(0, 2).equals("12")) {
                time = time.replace("12", "00");
            }
        } else if (hourType.equals("PM")) {
            if (!time.substring(0, 2).equals("12")) {
                time = time.replace(time.substring(0, 2), String.valueOf(Integer.parseInt(time.substring(0, 2)) + 12));
            }
        }

        return time;
    }
}
