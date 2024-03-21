package CodingTest.softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(final String[] args) throws Exception {
        final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        final int[] split = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int totalWeight = split[0];
        final int typeNumber = split[1];

        final List<Gem> gems = new ArrayList<>();
        for (int i = 0; i < typeNumber; i++) {
            final String[] temp = bf.readLine().split(" ");
            gems.add(new Gem(temp[0], temp[1]));
        }

        gems.sort(Comparator.comparingInt(g -> (-1 * g.pricePerWeight)));


        int answer = 0;
        for (final Gem gem : gems) {
            final int weight = gem.weight;
            final int pricePerWeight = gem.pricePerWeight;

            if (weight > totalWeight) {
                answer += (totalWeight * pricePerWeight);
                break;
            }

            totalWeight -= weight;
            answer += (weight * pricePerWeight);
        }

        System.out.println(answer);
    }

    static class Gem {
        int weight;
        int pricePerWeight;

        Gem(final String weight, final String price) {
            this.weight = Integer.parseInt(weight);
            this.pricePerWeight = Integer.parseInt(price);
        }
    }
}

