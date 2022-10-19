class Solution {
    public int solution(String before, String after) {
        int[] beforeArr = countCharNum(before);
        int[] afterArr = countCharNum(after);

        for (int i = 0; i < afterArr.length; i++) {
            int bi = beforeArr[i];
            int ai = afterArr[i];

            if (bi != ai) {
                return 0;
            }
        }

        return 1;
    }

    private int[] countCharNum(String str) {
        int[] rtArr = new int[30];

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            rtArr[idx]++;
        }

        return rtArr;
    }
}
