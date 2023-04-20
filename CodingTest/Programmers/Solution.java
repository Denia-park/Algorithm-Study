package CodingTest.Programmers;

//과제 진행하기

//23년 4월 21일 오전 12시 30분 시작

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<Plan> answers = new ArrayList<>();

        List<Plan> planList = new ArrayList<>();
        for (String[] plan : plans) {
            planList.add(new Plan(plan[0], plan[1], plan[2]));
        }

        planList.sort(Comparator.comparingInt(p -> p.startMinute));

        Deque<Plan> waitQueue = new ArrayDeque<>();

        Plan curPlan = planList.get(0);
        int curTime = curPlan.startMinute;

        int listIdx = 1;
        while (true) {
            if (listIdx == planList.size()) {
                answers.add(curPlan);
                break;
            }

            Plan nextPlan = planList.get(listIdx);

            if (curPlan.endMinute > nextPlan.startMinute) {
                curPlan.remainMinute -= nextPlan.startMinute - curTime;
                curTime = nextPlan.startMinute;
                waitQueue.addLast(curPlan);
                curPlan = nextPlan;
                listIdx++;
            } else if (curPlan.endMinute == nextPlan.startMinute) {
                curPlan.remainMinute = 0;
                curTime = nextPlan.startMinute;
                answers.add(curPlan);
                curPlan = nextPlan;
                listIdx++;
            } else {
                curPlan.remainMinute = 0;
                curTime = curPlan.endMinute;
                answers.add(curPlan);

                while (!waitQueue.isEmpty()) {
                    Plan waitPlan = waitQueue.pollLast();

                    if (curTime + waitPlan.remainMinute > nextPlan.startMinute) {
                        waitPlan.remainMinute -= (nextPlan.startMinute - (curTime + waitPlan.startMinute));
                        curTime = waitPlan.startMinute;
                        waitQueue.addLast(waitPlan);
                        curPlan = nextPlan;
                        listIdx++;
                        break;
                    } else if (curTime + waitPlan.remainMinute == nextPlan.startMinute) {
                        waitPlan.remainMinute = 0;
                        curTime = nextPlan.startMinute;
                        answers.add(waitPlan);
                        curPlan = nextPlan;
                        listIdx++;
                        break;
                    } else {
                        waitPlan.remainMinute = 0;
                        curTime = waitPlan.endMinute;
                        answers.add(waitPlan);
                    }
                }
            }
        }

        while (!waitQueue.isEmpty()) {
            Plan waitPlan = waitQueue.pollLast();
            answers.add(waitPlan);
        }

        return answers.stream().map(p -> p.subject).toArray(String[]::new);
    }

    static class Plan {
        String subject;
        int startMinute;
        int remainMinute;
        int endMinute;

        public Plan(String subject, String startTime, String remainMinute) {
            this.subject = subject;
            this.startMinute = convertTime(startTime);
            this.remainMinute = Integer.parseInt(remainMinute);
            this.endMinute = this.startMinute + this.remainMinute;
        }

        private int convertTime(String startTime) {
            String[] time = startTime.split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            return hour * 60 + minute;
        }
    }
}
