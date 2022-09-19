package BinarySearching;

// 떡볶이 떡 만들기
public class BinarySearching1 {
    public static void main(String[] args) {
        //떡 개수
        int n = 4;
        //요청한 떡의 길이
        int m = 6;
        //떡 길이 배열
        int[] lengthsOfRicecake = {19, 15, 10, 17};

        System.out.println(solve(n, m, lengthsOfRicecake));
    }

    private static int solve(int n, int customerWantLength, int[] lengthsOfRicecake) {
        int answer = 0;
        //떡의 개수
        int numOfRicecake = lengthsOfRicecake.length;

        //이진 탐색을 위해서 시작점 , 끝점 을 구함
        int binaryStart = 0;
        int binaryEnd = 0;

        //끝점을 구하기 위해서 떡 중에 제일 긴 것을 고름
        for(int length : lengthsOfRicecake) {
            binaryEnd = Math.max(binaryEnd, length);
        }

        //이진 탐색 수행
        while(binaryStart <= binaryEnd) {
            //이진 탐색에 사용될 중간 값을 구한다.
            int binaryMid = (binaryStart + binaryEnd) / 2;
            // 중간 값이자 잘라야될 떡의 길이
            int cutLength = binaryMid;
            // 손님이 요청한 떡의 길이를 비교하기 위해서 떡 길이들을 더해서 보관할 변수
            // ★떡의 길이들의 총합이 int 값의 Max 를 넘을수도 있으므로 long 으로 할당한다.
            long totalLength = 0;

            // cutLength가 정해졌으므로 해당 길이만큼 자르고 잘린 떡의 길이의 총합을 구한다.
            for(int length : lengthsOfRicecake) {
                if(length > cutLength)
                    totalLength += (length - cutLength);
            }

            //자른 길이가 원하는 값보다 크다면 많이 자른 것이므로 일단 answer에 값을 저장한다 (더 못자를수도 있으므로 일단 저장)
            //이진 탐색을 이어하기 위해서 binaryStart에 binaryMid + 1 을 해주고 이진 탐색을 이어 간다.
            if(totalLength > customerWantLength){
                answer = cutLength;
                binaryStart = binaryMid + 1;
            }
            // 길이가 딱 맞으면 더 이상 이진탐색을 할 필요가 없으므로 break
            else if(totalLength == customerWantLength){
                answer = cutLength;
                break;
            }
            // 길이가 모자르다면 떡을 더 많이 잘라야 한다.
            // 이진 탐색을 이어하기 위해서 binaryEnd에 binaryMid + 1 을 해주고 이진 탐색을 이어 간다.
            else{
                binaryEnd = binaryMid - 1;
            }
        }

        return answer;
    }

}

// 나동빈님 코드

//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // 떡의 개수(N)와 요청한 떡의 길이(M)
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        // 각 떡의 개별 높이 정보
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        // 이진 탐색을 위한 시작점과 끝점 설정
//        int start = 0;
//        int end = (int) 1e9;
//        // 이진 탐색 수행 (반복적)
//        int result = 0;
//        while (start <= end) {
//            long total = 0;
//            int mid = (start + end) / 2;
//            for (int i = 0; i < n; i++) {
//                // 잘랐을 때의 떡의 양 계산
//                if (arr[i] > mid) total += arr[i] - mid;
//            }
//            if (total < m) { // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
//                end = mid - 1;
//            }
//            else { // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
//                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
//                start = mid + 1;
//            }
//        }
//
//        System.out.println(result);
//    }
//
//}
