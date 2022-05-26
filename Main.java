package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int treeNum = Integer.parseInt(st.nextToken());
        int needLength = Integer.parseInt(st.nextToken());

        int[] trees = new int[treeNum];

        st = new StringTokenizer(br.readLine());

        int min = 0;
        int max = 0;
        int mid = 0;

        for(int i = 0; i<trees.length; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            if(max < trees[i])
                max = trees[i];
        }

        //그냥 풀면 시간 초과 걸리므로
        //이분 탐색으로 풀어야 된다.
        //처음에 min < max로 넣었다가 틀렸는데 테스트케이스를 보고 이유를 알았다.
        //tc 1 . 2 5
        //       7 9
        //min == max 일때 값을 확인해서 값이 맞지 않으면 다시 한번 더 처리를 해줘야함
        while(min <= max){
            mid = (min + max) / 2;
            long totalLength = 0;

            //자른 나무의 총 길이 구하는 코드
            for (int i = 0; i < treeNum; i++) {
                if(trees[i] > mid)
                    totalLength += trees[i] - mid;
            }

            //범위를 넘겼다는건 너무 많이 잘랏다는 뜻
            //조금만 자르게 min 값을 수정하자.
            if(totalLength > needLength){
                min = mid + 1;
            }
            //정답 이므로 mid 값을 제출
            else if (totalLength == needLength){
                System.out.println(mid);
                return;
            }
            //범위에 못미친다는건 너무 적게 잘랏다는 뜻
            //많이 자르게 max 값을 수정하자.
            else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
}

//안쓰는 코드 모음

//        *Sacnner*
//        Scanner scanner = new Scanner(System.in);
//        String testCaseNumStr = scanner.nextLine();
//        int testCaseNum = Integer.parseInt(testCaseNumStr);
//        String[] testCaseArray = new String[testCaseNum];
//
//        for (int i = 0; i < testCaseNum; i++) {
//            testCaseArray[i] = scanner.nextLine();
//        }

//        *StringTokenizer*
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int stNum = Integer.parseInt(st.nextToken());
//        int testValue = Integer.parseInt(br.readLine());

//        *BufferedReader*
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int testCaseNum = Integer.parseInt(br.readLine());
//        String[] testCase = new String[testCaseNum];
//        for (int i = 0; i < testCaseNum; i++) {
//            testCase[i] = br.readLine();
//        }

//    // N의 진짜 약수의 개수
//    int testCase = Integer.parseInt(br.readLine());
//    int[] inputArray = new int[testCase];
//
//    // N의 진짜 약수
//    StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//                for (int i = 0; i < testCase; i++) {
//        inputArray[i] = Integer.parseInt(st.nextToken());
//        }

