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

    private ArrayList<String> cloneArrayList(ArrayList<String> source) {
        ArrayList<String> result = new ArrayList<>(source.size());
        result.addAll(source);
        return result;
    }

    protected int getOxygenValue(ArrayList<String> originalValues) {
        ArrayList<String> values = cloneArrayList(originalValues);

        String result = null;
        for (int i = 0; i < originalValues.get(0).length(); i++) {
            if (result != null) break;

            char bitCriteria = getCommonUncommonBit(values, i).first;

            for (int j = 0; j < values.size(); j++) {
                if (values.get(j).charAt(i) != bitCriteria) {
                    values.remove(j);
                    j--;
                }
                if (values.size() == 1) {
                    result = values.get(0);
                }
            }
        }

        if (result == null) {
            throw new RuntimeException("Day03 getOxygenValue: Value not found");
        }

        return Integer.parseInt(result, 2);
    }

    protected int getCO2Values(ArrayList<String> originalValues) {
        ArrayList<String> values = cloneArrayList(originalValues);

        String result = null;
        for (int i = 0; i < originalValues.get(0).length(); i++) {
            if (result != null) break;

            char bitCriteria = getCommonUncommonBit(values, i).second;

            for (int j = 0; j < values.size(); j++) {
                if (values.get(j).charAt(i) != bitCriteria) {
                    values.remove(j);
                    j--;
                }
                if (values.size() == 1) {
                    result = values.get(0);
                }
            }
        }

        if (result == null) {
            throw new RuntimeException("Day03 getOxygenValue: Value not found");
        }

        return Integer.parseInt(result, 2);
    }

    protected String secondPart(ArrayList<String> values) {
        return (getOxygenValue(values) * getCO2Values(values)) + "";
    }

    @Override
    public Pair<String, String> solve() {
        ArrayList<String> values = loadStringValues();
        return new Pair<>(firstPart(values), secondPart(values));
    }
}
