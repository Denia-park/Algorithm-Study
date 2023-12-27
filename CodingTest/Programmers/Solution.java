package CodingTest.Programmers;

//1번 : 1 2 3 4 5
//2번 : 2 1 2 3 2 4 2 5
//3번 : 3 3 1 1 2 2 4 4 5 5

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(final int[] answers) {
        final int[] answer = {};

        final List<Student> students = new ArrayList<>(
                List.of(
                        new Student(1, new int[]{1, 2, 3, 4, 5}),
                        new Student(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}),
                        new Student(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5})
                )
        );

        for (final int val : answers) {
            for (final Student student : students) {
                student.checkAnswer(val);
            }
        }

        students.sort(null);

        if (students.get(0).score != students.get(1).score) {
            return new int[]{
                    students.get(0).number
            };
        } else if (students.get(1).score != students.get(2).score) {
            return new int[]{
                    students.get(0).number,
                    students.get(1).number
            };
        } else {
            return new int[]{
                    students.get(0).number,
                    students.get(1).number,
                    students.get(2).number
            };
        }
    }

    static class Student implements Comparable<Student> {
        int number;
        int score;
        int[] pattern;
        int patternIdx;

        public Student(final int number, final int[] pattern) {
            this.number = number;
            this.score = 0;
            this.pattern = pattern;
            this.patternIdx = 0;
        }

        public int getNumber() {
            return number;
        }

        public void checkAnswer(final int answer) {
            if (this.pattern[this.patternIdx] == answer) {
                this.score++;
            }

            this.patternIdx = (this.patternIdx + 1) % this.pattern.length;
        }

        @Override
        public int compareTo(final Student o) {
            if (o.score == this.score) {
                return Integer.compare(this.number, o.number);
            }

            return Integer.compare(o.score, this.score);
        }
    }
}
