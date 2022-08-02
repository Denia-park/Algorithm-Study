//package com.company;
//
//import java.util.Stack;
//
//public class Quiz3 {
//    static public void main(String[] args) {
//        int[] quiz1 = { 4,3,1,2,5 };
//        int[] quiz2 = { 5,4,3,2,1 };
//
//        System.out.println(solution(quiz1) == 2);
//        System.out.println(solution(quiz2) == 5);
//    }
//
//    static public int solution(int[] order) {
//        int answer = 0;
//        Stack<Integer> stack = new Stack<Integer>();
//        // order 길이만큼이 box의 총량
//        int boxTotalNum = order.length;
//        //boxIndex 는 1번 박스부터 시작
//        int boxIndex = 1;
//        //현재까지 처리된 order 박스 Index
//        int orderIndex = 0;
//
//        while (true){
//            // order[orderIndex] 와 boxIndex 가 다른 상황인데 order[orderIndex] 가 boxIndex 보다 크다면,
//            // boxIndex 를 stack에 집어 넣는 것으로 order[orderIndex] 를 맞출 수 있으므로 stack 에 boxIndex 를 Push 한다.
//            // 그런데 만약 order[orderIndex] 가 boxIndex 보다 작다면 일단 stack 에 들어있는 것을 확인하고
//            // stack 에서도 해당 값이 없다면 box 를 stack 에 집어 집어넣어도 쓸모가 없다.
//            if (order[orderIndex] != boxIndex && order[orderIndex] > boxIndex) {
//                stack.push(boxIndex);
//                boxIndex++;
//            }
//            // boxIndex 와 order[orderIndex] 가 같으므로 answer 를 한개 올리고 boxIndex 를 올린다.
//            // orderIndex 도 올려야 하는데 그냥 ++ 하면은 OutOfRangeError 가 뜨므로 조건을 걸었다.
//            else if (order[orderIndex] == boxIndex) {
//                boxIndex++;
//                answer++;
//                if(orderIndex + 1 != boxTotalNum)
//                    orderIndex++;
//            }
//            // boxIndex 로 order[orderIndex]를 맞출 수 없을 때 stack 을 확인해야 하며
//            // stack 을 사용할때는 Empty 인지 확인 후에 사용해야함
//            // 그리고 peek 를 사용해서 일단 최상단 값을 확인하고 맞으면 pop 을 해준다.
//            // answer 와 orderIndex 관련은 바로 위에 와 같다.
//            else if ( !stack.isEmpty() && stack.peek() == order[orderIndex]) {
//                stack.pop();
//                answer++;
//                if(orderIndex + 1 != boxTotalNum)
//                    orderIndex++;
//            }
//            // 위의 3조건에 아무것도 해당하지 않는 경우에는 while 을 지속하는 의미가 없으므로 break 로 빠져나온다.
//            else {
//                break;
//            }
//        }
//
//        return answer;
//    }
//}
