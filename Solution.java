import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] feeInfos, String[] records) {
        Map<String, Car> carMap = new TreeMap<>();

        updateCarDbByRecords(carMap, records);

        int[] answer = new int[carMap.size()];

        calculateCarParkingTimeOnMidnight(carMap);

        applyTotalFeeToAnswerArray(carMap, answer, feeInfos);

        return answer;
    }

    private void updateCarDbByRecords(Map<String, Car> carMap, String[] records) {
        for (String record : records) {
            String[] recordArr = record.split(" ");
            String time = recordArr[0];
            String carNum = recordArr[1];
            String inOut = recordArr[2];

            if (inOut.equals("IN")) {
                Car myCar = carMap.get(carNum);
                if (myCar == null) {
                    carMap.put(carNum, new Car(carNum, time));
                } else {
                    myCar.setEnterTime(time);
                }
            } else {
                Car myCar = carMap.get(carNum);
                myCar.setExitTime(time);

                int parkingTime = myCar.getParkingTime();
                myCar.setTotalParkingTime(myCar.getTotalParkingTime() + parkingTime);
            }
        }
    }

    private void applyTotalFeeToAnswerArray(Map<String, Car> carMap, int[] answer, int[] feeInfos) {
        int idx = 0;
        for (Map.Entry<String, Car> carEntry : carMap.entrySet()) {
            Car myCar = carEntry.getValue();
            answer[idx] = calculateFee(myCar, feeInfos);
            idx++;
        }
    }

    private void calculateCarParkingTimeOnMidnight(Map<String, Car> carMap) {
        for (Map.Entry<String, Car> carEntry : carMap.entrySet()) {
            Car myCar = carEntry.getValue();

            if (myCar.getEnterTime() == null)
                continue;

            if (myCar.getExitTime() == null) {
                myCar.setExitTime("23:59");
            }

            int totalTime = myCar.getParkingTime();
            myCar.setTotalParkingTime(myCar.getTotalParkingTime() + totalTime);
        }
    }

    private int calculateFee(Car myCar, int[] feeInfos) {
        int defaultTime = feeInfos[0];
        int defaultFee = feeInfos[1];
        int unitTime = feeInfos[2];
        int unitFee = feeInfos[3];

        int totalParkingTime = myCar.getTotalParkingTime();
        int totalFee = 0;

        if (totalParkingTime <= defaultTime) {
            totalFee = defaultFee;
        } else {
            double additionalTime = totalParkingTime - defaultTime;
            int additionalFee = (int) Math.ceil(additionalTime / unitTime) * unitFee;

            totalFee = defaultFee + additionalFee;
        }

        return totalFee;
    }
}

class Car {
    private final String carNum;
    private String enterTime;
    private String exitTime;
    private int totalParkingTime;

    public Car(String carNum, String enterTime) {
        this.carNum = carNum;
        this.enterTime = enterTime;
        this.exitTime = null;
        this.totalParkingTime = 0;
    }

    public String getCarNum() {
        return carNum;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public int getTotalParkingTime() {
        return totalParkingTime;
    }

    public void setTotalParkingTime(int totalParkingTime) {
        this.totalParkingTime = totalParkingTime;
    }

    public int getParkingTime() {
        if (this.enterTime == null || this.exitTime == null)
            return -1;

        String[] enterTimeArr = this.enterTime.split(":");
        String[] exitTimeArr = this.exitTime.split(":");

        int enterTimeTotal = Integer.parseInt(enterTimeArr[0]) * 60 + Integer.parseInt(enterTimeArr[1]);
        int exitTimeTotal = Integer.parseInt(exitTimeArr[0]) * 60 + Integer.parseInt(exitTimeArr[1]);

        this.enterTime = null;
        this.exitTime = null;

        return exitTimeTotal - enterTimeTotal;
    }
}
