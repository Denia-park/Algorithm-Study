package CodingTest.Programmers;

import java.util.HashMap;
import java.util.Map;

/*
아이디어 - 구현
 */

class Solution {
    public int solution(final String[] friends, final String[] gifts) {

        //선물 준거, 받은거 기록 필요함
        final Map<String, int[]> giftSendReceive = new HashMap<>();
        //각 친구들에대해서 선물 준거 기록 필요함
        final Map<String, Map<String, Integer>> giftFriend = new HashMap<>();
        //다음 달에 받을 선물
        final Map<String, Integer> nextMonthReceive = new HashMap<>();

        //Map 초기화
        for (final String curName : friends) {
            giftSendReceive.put(curName, new int[2]);
            nextMonthReceive.put(curName, 0);

            final Map<String, Integer> tempMap = new HashMap<>();
            for (final String toFriend : friends) {
                if (curName.equals(toFriend)) continue;
                tempMap.put(toFriend, 0);
            }
            giftFriend.put(curName, tempMap);
        }

        //선물을 주자
        for (final String gift : gifts) {
            final String[] split = gift.split(" ");
            final String from = split[0];
            final String to = split[1];

            final int[] fromSendReceive = giftSendReceive.get(from);
            final int[] toSendReceive = giftSendReceive.get(to);

            fromSendReceive[0]++; //from이 준거 업데이트
            toSendReceive[1]++; //to가 받은거 업데이트

            final Integer giftedValue = giftFriend.get(from).get(to);
            giftFriend.get(from).put(to, giftedValue + 1);
        }

        //조합으로 친구 모두 비교하면서 개수 세기
        for (int aIdx = 0; aIdx < friends.length; aIdx++) {
            for (int bIdx = aIdx + 1; bIdx < friends.length; bIdx++) {
                final String aFriend = friends[aIdx];
                final String bFriend = friends[bIdx];

                //선물을 주고 받은 기록이 있으면, 더 많은 선물을 준 사람이 받는다
                if (giftFriend.get(aFriend).get(bFriend) != 0 ||
                        giftFriend.get(bFriend).get(aFriend) != 0) {
                    final int faToFb = giftFriend.get(aFriend).get(bFriend);
                    final int fbToFA = giftFriend.get(bFriend).get(aFriend);

                    //둘이서 주고 받은 선물의 수가 다르면
                    if (faToFb != fbToFA) {
                        //fa가 준게 더 많으면
                        if (faToFb > fbToFA) {
                            nextMonthReceive.put(aFriend, nextMonthReceive.get(aFriend) + 1);
                        }
                        //fb가 준게 더 많으면
                        else {
                            nextMonthReceive.put(bFriend, nextMonthReceive.get(bFriend) + 1);
                        }

                        continue;
                    }
                }

                //받은 기록이 없거나, 같으면 선물지수가 큰 사람이 받는다.
                final int[] aSendReceive = giftSendReceive.get(aFriend);
                final int aGiftValue = aSendReceive[0] - aSendReceive[1];
                final int[] bSendReceive = giftSendReceive.get(bFriend);
                final int bGiftValue = bSendReceive[0] - bSendReceive[1];


                //선물지수 까지 같으면 주고 받지 않는다.
                if (aGiftValue == bGiftValue) {
                    continue;
                }

                if (aGiftValue > bGiftValue) {
                    nextMonthReceive.put(aFriend, nextMonthReceive.get(aFriend) + 1);
                } else {
                    nextMonthReceive.put(bFriend, nextMonthReceive.get(bFriend) + 1);
                }
            }
        }

        return nextMonthReceive.values().stream()
                .mapToInt(i -> i).max().getAsInt();
    }
}
