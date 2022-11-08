import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] feeInfos, String[] records) {
        Map<String, Car> carMap = new TreeMap<>();

        updateCarDbByRecords(carMap, records, feeInfos);

        int[] answer = new int[carMap.size()];

        calculateMidnightFee(carMap, feeInfos);

        applyTotalFeeToAnswerArray(carMap, answer);

        return answer;
    }

    private void updateCarDbByRecords(Map<String, Car> carMap, String[] records, int[] feeInfos) {
        for (String record : records) {
            String[] recordArr = record.split(" ");
            String time = recordArr[0];
            String carNum = recordArr[1];
            String inOut = recordArr[2];

            if (inOut.equals("IN")) {
                carMap.put(carNum, new Car(carNum, time));
            } else {
                Car myCar = carMap.get(carNum);
                myCar.setExitTime(time);

                int totalFee = getFee(myCar, feeInfos);
                myCar.setTotalFee(myCar.getTotalFee() + totalFee);
            }
        }
    }

    private void applyTotalFeeToAnswerArray(Map<String, Car> carMap, int[] answer) {
        int idx = 0;
        for (Map.Entry<String, Car> carEntry : carMap.entrySet()) {
            Car myCar = carEntry.getValue();
            answer[idx] = myCar.getTotalFee();
            idx++;
        }
    }

    private void calculateMidnightFee(Map<String, Car> carMap, int[] feeInfos) {
        for (Map.Entry<String, Car> carEntry : carMap.entrySet()) {
            Car myCar = carEntry.getValue();

            if (myCar.getEnterTime() == null)
                continue;

            int feeOfMidnight = getFee(myCar, feeInfos);

            myCar.setTotalFee(myCar.getTotalFee() + feeOfMidnight);
        }
    }

    private int getFee(Car myCar, int[] feeInfos) {
        int defaultTime = feeInfos[0];
        int defaultFee = feeInfos[1];
        int unitTime = feeInfos[2];
        int unitFee = feeInfos[3];

        String enterTime = myCar.getEnterTime();
        String exitTime = myCar.getExitTime();

        if (exitTime == null) {
            exitTime = "23:59";
        }
        int totalTime = calculateTime(enterTime, exitTime);
        int totalFee = 0;

        if (totalTime <= defaultTime) {
            totalFee = defaultFee;
        } else {
            double additionalTime = totalTime - defaultTime;
            int additionalFee = (int) Math.ceil(additionalTime / unitTime) * unitFee;

            totalFee = defaultFee + additionalFee;
        }

        return totalFee;
    }

    private int calculateTime(String enterTime, String exitTime) {
        String[] enterTimeArr = enterTime.split(":");
        String[] exitTimeArr = exitTime.split(":");

        int enterTimeTotal = Integer.parseInt(enterTimeArr[0]) * 60 + Integer.parseInt(enterTimeArr[0]);
        int exitTimeTotal = Integer.parseInt(exitTimeArr[0]) * 60 + Integer.parseInt(exitTimeArr[0]);

        return enterTimeTotal - exitTimeTotal;
    }
}

class Car {
    private final String carNum;
    private String enterTime;
    private String exitTime;
    private int totalFee;

    public Car(String carNum, String enterTime) {
        this.carNum = carNum;
        this.enterTime = enterTime;
        this.exitTime = null;
        this.totalFee = 0;
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

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }
}
