package CodingTest.Programmers;

import java.util.*;

class Solution {
    public int[] solution(final int[] fees, final String[] records) {
        //모든 출차 기록을 가지고 차들에 대한, 누적 주차 시간을 구한다.
        //출입시 찍힘
        final Map<String, String> parkInput = new HashMap<>();

        //Set으로 주차장 관리
        final Set<String> park = new HashSet<>();

        //주차장을 이용한 이용내역 (총 시간만 저장)
        final Map<String, Integer> cars = new TreeMap<>();

        for (final String record : records) {
            //In, Out 판단
            final String[] split = record.split(" ");
            final String time = split[0];
            final String carNumber = split[1];
            final String ioStr = split[2];

            //In이면 주차장에 넣고, 시간 넣기
            if (ioStr.equals("IN")) {
                park.add(carNumber);
                parkInput.put(carNumber, time);
            }
            //Out이면 주차장에서 빼기, 시간 빼기, 이용내역에 업데이트
            else {
                park.remove(carNumber);

                final String inputTime = parkInput.get(carNumber);
                final String outputTime = time;
                addTimeToCar(cars, carNumber, inputTime, outputTime);
            }
        }

        //아직 주차장에 남아있는 차들을 시간 계산하기 -> 이용내역에 업데이트
        for (final String carNumber : park) {
            final String inputTime = parkInput.get(carNumber);
            final String outputTime = "23:59";
            addTimeToCar(cars, carNumber, inputTime, outputTime);
        }

        //차량번호가 작은 자동차부터 차례대로 return (TreeMap 사용)
        final int[] answer = new int[cars.size()];

        int idx = 0;
        for (final int time : cars.values()) {
            answer[idx++] = calculateCostByTime(time, fees);
        }

        return answer;
    }

    private void addTimeToCar(final Map<String, Integer> cars, final String carNumber, final String inputTime, final String outputTime) {
        final int totalTime = cars.getOrDefault(carNumber, 0) + calculateTime(inputTime, outputTime);
        cars.put(carNumber, totalTime);
    }

    private int calculateTime(final String inputTime, final String outTime) {
        final int inMin = convertTimeToMin(inputTime);
        final int outMin = convertTimeToMin(outTime);

        return outMin - inMin;
    }

    private int convertTimeToMin(final String inputTime) {
        final String[] split = inputTime.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private int calculateCostByTime(final int totalTime, final int[] fees) {
        final int defaultTime = fees[0];
        final int defaultFee = fees[1];
        final int perTime = fees[2];
        final int perFee = fees[3];

        if (totalTime <= defaultTime) {
            return defaultFee;
        }

        final int restTime = totalTime - defaultTime;
        return defaultFee + ((int) Math.ceil((double) restTime / perTime) * perFee);
    }
}
