import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {

        //문제에 정의된 대로 정렬하면 된다.
            //Comparator를 구현하여 직접 정렬하게 만들자.
        Arrays.sort(files,new Comparator<String>(){
            @Override
            public int compare(String _o1, String _o2) {
                //o1 , o2 모두 소문자로 만든다.
                String o1 = _o1.toLowerCase();
                String o2 = _o2.toLowerCase();

                //숫자가 시작하는 Index 와 숫자가 끝나는 Index를 구한다.
                int[] o1Indexes = getNumberTailIndex(o1);
                int o1NumIdx = o1Indexes[0];
                int o1TailIdx = o1Indexes[1];

                //숫자가 시작하는 Index 와 숫자가 끝나는 Index를 구한다.
                int[] o2Indexes = getNumberTailIndex(o2);
                int o2NumIdx = o2Indexes[0];
                int o2TailIdx = o2Indexes[1];

                //앞의 Head가 동일하면 뒤의 숫자를 비교해서 정렬
                if(o1.substring(0,o1NumIdx).equals(o2.substring(0,o2NumIdx))){
                    int o1Num = Integer.parseInt(o1.substring(o1NumIdx, o1TailIdx));
                    int o2Num = Integer.parseInt(o2.substring(o2NumIdx, o2TailIdx));

                    return o1Num - o2Num;
                }

                //Head가 다르면 Head를 비교해서 정렬
                return o1.substring(0,o1NumIdx).compareTo(o2.substring(0,o2NumIdx));
            }
        });

        return files;
    }

    //Number 와 Tail 의 Index를 구하는 메서드
    private int[] getNumberTailIndex(String str) {
        //리턴할 arr을 생성
        int[] rtArr = new int[2];

        //Tail의 index는 str의 길이로 초기화
            //아래에서 rtArr[1] 을 구할 때 혹시라도 조건이 맞지 않으면 업데이트 되지 않으므로,
            //업데이트가 되지 않은 경우에는 Tail이 str의 끝이라고 보면 된다.
        rtArr[1] = str.length();

        //Number 는 5개 까지만 가능하므로 세는 변수가 존재해야함
        int numCount = 0;

        //Head가 끝나고 Number가 시작하는 Index를 찾고 break
        for (int i = 0; i < str.length(); i++) {
            if(i == 0) continue;
            if(!Character.isDigit(str.charAt(i - 1)) && Character.isDigit(str.charAt(i))){
                rtArr[0] = i;
                break;
            }
        }

        //Number가 시작하는 것으로 부터 5개의 숫자가 넘거나 숫자가 아닌 값이 오면 rtArr[1] 값을 업데이트 하고 break
        //숫자가 계속해서 이어지면 numCount 를 업데이트 하는 것으로 현재 숫자가 몇개가 나왔는지를 센다.
        for (int i = rtArr[0]; i < str.length(); i++) {
            if(numCount < 5 && Character.isDigit(str.charAt(i))){
                numCount ++;
            }else{
                rtArr[1] = i;
                break;
            }
        }

        //지금까지 구한 arr를 return
        return rtArr;
    }
}
