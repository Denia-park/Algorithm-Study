package CodingTest.Programmers;

class Solution {
    public String solution(final String s) {
        final char[] chars = s.toCharArray();

        insertionSort(chars);

        return String.valueOf(chars);
    }

    private void insertionSort(final char[] chars) {
        //1번째부터 끝까지 돌면서 자기 자리를 찾는다.
        for (int selectIdx = 1; selectIdx < chars.length; selectIdx++) {
            final char selectValue = chars[selectIdx];
            int diffIdx = selectIdx - 1;

            //0번째까지 다 비교를 해서 자기 자리를 찾는다.
            for (; diffIdx >= 0; diffIdx--) {
                final char diffValue = chars[diffIdx];

                //자기 자리를 찾을 때 까지 앞의 값들을 뒤로 복사한다.
                if (diffValue >= selectValue) {
                    break;
                }

                chars[diffIdx + 1] = diffValue;
            }

            chars[diffIdx + 1] = selectValue;
        }
    }
}
