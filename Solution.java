import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files,new Comparator<String>(){
            @Override
            public int compare(String _o1, String _o2) {
                String o1 = _o1.toLowerCase();
                String o2 = _o2.toLowerCase();
                int[] o1Indexes = getNumberTailIndex(o1);
                int o1NumIdx = o1Indexes[0];
                int o1TailIdx = o1Indexes[1];

                int[] o2Indexes = getNumberTailIndex(o2);
                int o2NumIdx = o2Indexes[0];
                int o2TailIdx = o2Indexes[1];

                if(o1.substring(0,o1NumIdx).equals(o2.substring(0,o2NumIdx))){
                    int o1Num = Integer.parseInt(o1.substring(o1NumIdx, o1TailIdx));
                    int o2Num = Integer.parseInt(o2.substring(o2NumIdx, o2TailIdx));

                    return o1Num - o2Num;
                }
                return o1.substring(0,o1NumIdx).compareTo(o2.substring(0,o2NumIdx));
            }
        });

        return files;
    }

    private int[] getNumberTailIndex(String str) {
        int[] rtArr = new int[2];
        rtArr[1] = -1;

        int numCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if(i == 0) continue;
            if(!Character.isDigit(str.charAt(i - 1)) && Character.isDigit(str.charAt(i))){
                rtArr[0] = i;
                break;
            }
        }

        for (int i = rtArr[0]; i < str.length(); i++) {
            if(numCount < 5 && Character.isDigit(str.charAt(i))){
                numCount ++;
            }else{
                rtArr[1] = i;
                break;
            }
        }

        return rtArr;
    }
}
