package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lottery {


    private List<Integer> createLotteryBalls(int balls){


        List<Integer> lotteryBalls = new ArrayList<>();

        for (int i = 0; i < balls; i++) {
            lotteryBalls.add(i+1);
        }

        Collections.shuffle(lotteryBalls);

        return lotteryBalls;
    }


    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {

        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }

        List<Integer> lotteryBalls = createLotteryBalls(ballCount);

        List<Integer> winners = lotteryBalls.subList(0, lotteryType);

        Collections.sort(winners);

        return winners;

    }

}
