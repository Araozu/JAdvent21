package solutions;

import environment.Environment;
import utils.Pair;

import java.util.ArrayList;

public class Day03 extends Solution {
    public Day03(Environment env) {
        super("03", env);
    }

    /**
     * Returns the common and least common bit in the column indicated by position.
     *
     * @param values   Array with String from where to extract the values
     * @param position The column where to count. Zero based.
     * @return A pair containing the more and least common bits, in that order.
     */
    protected Pair<Character, Character> getCommonUncommonBit(ArrayList<String> values, int position) {
        if (position < 0) {
            throw new RuntimeException("Day03 getCommonUncommonBit: index is less than zero.");
        }
        if (position >= values.get(0).length()) {
            throw new RuntimeException("Day03 getCommonUncommonBit: index is greater or equal than the first string length.");
        }
        int zeroCount = 0;
        int oneCount = 0;
        for (String s : values) {
            if (s.charAt(position) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        return zeroCount > oneCount ? new Pair<>('0', '1') : new Pair<>('1', '0');
    }

    /**
     * Returns the gamma and epsilon rate
     *
     * @param values ArrayList with Strings from where to get the values
     * @return The gamma and epsilon rate, in that order
     */
    protected Pair<Integer, Integer> getValues(ArrayList<String> values) {
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int i = 0; i < values.get(0).length(); i++) {
            Pair<Character, Character> result = getCommonUncommonBit(values, i);
            gamma.append(result.first);
            epsilon.append(result.second);
        }
        return new Pair<>(Integer.parseInt(gamma.toString(), 2), Integer.parseInt(epsilon.toString(), 2));
    }

    protected String firstPart(ArrayList<String> values) {
        Pair<Integer, Integer> result = getValues(values);
        return (result.first * result.second) + "";
    }

    @Override
    public Pair<String, String> solve() {
        return new Pair<>(firstPart(loadStringValues()), null);
    }
}
