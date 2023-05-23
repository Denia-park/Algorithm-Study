package CodingTest.Programmers;

/*
2021 카카오 채용연계형 인턴십 - 표 편집

아이디어
- 구현 , 배열 사용하고 배열은 고정, value만 값을 바꿔가면서 사용
- Z는 스택을 사용하자.

시간 복잡도
- 단순 구현말고는 일단은 더 나은 방법을 모르겠음 ..

자료 구조
- boolen[] , Stack<Integer> 로 처리

 */

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String solution(int totalNum, int curSel, String[] cmd) {
        boolean[] checked = new boolean[totalNum];
        Arrays.fill(checked, true);
        Stack<Integer> stack = new Stack<>();

        for (String comm : cmd) {
            String[] splits = comm.split(" ");

            String alpha = splits[0];

            int count = 0;
//            System.out.print("checked = " + Arrays.toString(checked));
//            System.out.println("curSel = " + curSel);

            if (alpha.equals("U")) {
                int moveCount = Integer.parseInt(splits[1]);
                while (moveCount != count) {
                    curSel--;

                    if (checked[curSel]) {
                        count++;
                    }
                }
            } else if (alpha.equals("D")) {
                int moveCount = Integer.parseInt(splits[1]);
                while (moveCount != count) {
                    curSel++;

                    if (checked[curSel]) {
                        count++;
                    }
                }
            } else if (alpha.equals("C")) {
                int nextSel = curSel + 1;
                boolean flag = false;
                //아래 행 선택
                while (true) {
                    if (nextSel == totalNum) {
                        break;
                    }

                    if (checked[nextSel]) {
                        flag = true;
                        break;
                    }
                    nextSel++;
                }

                if (!flag) {
                    //끝에 도달했으므로 윗 행 찾기
                    int tempUpSel = curSel - 1;
                    while (true) {
                        if (tempUpSel == -1) {
                            break;
                        }

                        if (checked[tempUpSel]) {
                            nextSel = tempUpSel;
                            break;
                        }
                        tempUpSel--;
                    }
                }

                //현재값 삭제
                checked[curSel] = false;
                stack.push(curSel);
                //다음 행 선택
                curSel = nextSel;
            } else if (alpha.equals("Z")) {
                int curDelIdx = stack.pop();
                checked[curDelIdx] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalNum; i++) {
            if (checked[i]) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }

        return sb.toString();
    }
}
