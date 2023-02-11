package CodingTest.Programmers.Test230211;


//당첨자만큼만 구매하면 모두 당첨
//당첨자 수보다 구매한 사람 수가 많으면 무작위로 당첨

//가장 확률이 높은 복권
//금액이 제일 높은 복권
//

import java.util.ArrayList;
import java.util.List;

//사게 될 복권 번호
public class Solution1 {
    public int solution(int[][] lotteries) {
        int answer = 0;
        List<Lottery> list = new ArrayList<>();
        int idx = 1;
        for (int[] lottery : lotteries) {
            list.add(new Lottery(lottery[0], lottery[1], lottery[2], idx));
            idx++;
        }

        list.sort(null);

        return list.get(0).idx;
    }
}

class Lottery implements Comparable<Lottery> {
    double winNum;
    double buyNum;
    int money;
    int idx;

    double percent;

    public Lottery(int winNum, int buyNum, int money, int idx) {
        this.winNum = winNum;
        this.buyNum = buyNum;
        this.money = money;
        this.idx = idx;

        this.percent = calculatePercent();
    }

    private double calculatePercent() {
        if (this.winNum >= (buyNum + 1)) {
            return 1;
        } else {
            return (this.winNum / (buyNum + 1));
        }
    }

    @Override
    public int compareTo(Lottery o) {
        if (this.percent > o.percent) {
            return -1;
        } else if (this.percent < o.percent) {
            return 1;
        } else {
            return Integer.compare(o.money, this.money);
        }
    }
}
