package CodingTest.Programmers;

//과제 진행하기

//23년 4월 21일 오전 12시 30분 시작

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<Plan> answers = new ArrayList<>();

        PriorityQueue<Plan> planList = new PriorityQueue<>(Comparator.comparingInt(p -> p.startMinute));
        for (String[] plan : plans) {
            planList.add(new Plan(plan[0], plan[1], plan[2]));
        }

        Deque<Plan> waitQueue = new ArrayDeque<>();

        while (!planList.isEmpty()) {
            Plan curPlan = planList.poll();

            //curPlan 이 마지막 계획
            if (planList.isEmpty()) {
                answers.add(curPlan);
                break;
            }

            Plan nextPlan = planList.peek();

            //다음 계획이 먼저 실행 -> 현재 계획은 wait으로
            if (curPlan.endMinute > nextPlan.startMinute) {
                curPlan.startMinute = nextPlan.startMinute;
                waitQueue.addLast(curPlan);
            }
            //다음 계획이 딱 맞게 실행
            else if (curPlan.endMinute == nextPlan.startMinute) {
                answers.add(curPlan);
            }
            //현재 계획이 먼저 끝남
            else {
                answers.add(curPlan);
                //현재 시간
                int curTime = curPlan.endMinute;

                //대기 Queue를 돌면서 대기 Plan을 확인
                while (!waitQueue.isEmpty()) {
                    //대기 Plan
                    Plan waitPlan = waitQueue.pollLast();

                    //대기 Plan의 남아있는 시간 확인
                    int remainMinute = waitPlan.endMinute - waitPlan.startMinute;

                    //다음 계획이 대기 Plan 보다 먼저 실행
                    if (curTime + remainMinute > nextPlan.startMinute) {
                        waitPlan.startMinute += nextPlan.startMinute - curTime;
                        waitQueue.addLast(waitPlan);
                        break;
                    }
                    //다음 계획이 대기 Plan 과 딱 맞게 실행
                    else if (curTime + remainMinute == nextPlan.startMinute) {
                        answers.add(waitPlan);
                        break;
                    }
                    //대기 Plan이 먼저 끝남
                    else {
                        answers.add(waitPlan);
                        curTime = waitPlan.endMinute;
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
        int endMinute;

        public Plan(String subject, String startTime, String remainMinute) {
            this.subject = subject;
            this.startMinute = convertTime(startTime);
            this.endMinute = this.startMinute + Integer.parseInt(remainMinute);
        }

        private int convertTime(String startTime) {
            String[] time = startTime.split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            return hour * 60 + minute;
        }
    }
}
