package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        String[] strings = firstLine.split(" ");
        int shootPlaceNum = Integer.parseInt(strings[0]);
        int animalNum = Integer.parseInt(strings[1]);
        int shootRange = Integer.parseInt(strings[2]);

        String[] shootPlaces = br.readLine().split(" ");
        String[] animals = new String[animalNum];

        for (int i = 0; i < animalNum; i++) {
            animals[i] = br.readLine();
        }

        sol.solution(shootPlaces, animals, shootRange);
    }
}

class BjSolution {
    int answer;

    public void solution(String[] shootPlaces, String[] animals, int shootRange) {
        answer = 0;
        int[] intShootPlaces = new int[shootPlaces.length];
        int idx = 0;
        for (String val : shootPlaces) {
            intShootPlaces[idx++] = Integer.parseInt(val);
        }

        Arrays.sort(intShootPlaces);

        for (String val : animals) {
            String[] arr = val.split(" ");
            int animalX = Integer.parseInt(arr[0]);
            int animalY = Integer.parseInt(arr[1]);

            if (animalY > shootRange) continue;

            int range = shootRange - animalY;
            int availableShootRangePlus = animalX + range;
            int availableShootRangeMinus = animalX - range;

            int count = countByRange(intShootPlaces, availableShootRangeMinus, availableShootRangePlus);
            if (count > 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    private int countByRange(int[] arr, int leftValue, int rightValue) {
        // **유의: lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정**
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        return rightIndex - leftIndex;
    }

    private int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    private int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}

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
