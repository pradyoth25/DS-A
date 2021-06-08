package leetcode_solved.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JudgePoint24 {

    public boolean judgePoint24(int[] cards) {
        List<Double> temp = new ArrayList<>();
        for (int card : cards) temp.add((double) card);
        return helper(temp);
    }

    private boolean helper(List<Double> list) {
        if (list.size() == 1) return Math.abs(list.get(0) - 24) < 0.001;
        for (int i = 0; i < list.size(); i ++) {
            for (int j = i + 1; j < list.size(); j ++) {
                List<Double> nextValues = getNextValues(list.get(i), list.get(j));
                for (double c : nextValues) {
                    List<Double> nextRound = new ArrayList<>();
                    nextRound.add(c);
                    for (int k = 0; k < list.size(); k ++) {
                        if (k == i || k == j) continue;
                        nextRound.add(list.get(k));
                    }
                    if (helper(nextRound)) return true;
                }
            }
        }
        return false;
    }

    private List<Double> getNextValues(double a, double b) {
        return Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
    }

}
