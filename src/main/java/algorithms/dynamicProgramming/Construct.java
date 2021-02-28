package algorithms.dynamicProgramming;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Construct {

    /**
     * CAN CONSTRUCT
     * @param target
     * @param words
     * @return
     */

    public boolean naiveCanConstruct(String target, List<String> words) {
        if (target.isEmpty()) return true;
        for (String word : words) {
            if (target.startsWith(word) && naiveCanConstruct(target.substring(word.length()), words)) {
                return true;
            }
        }
        return false;
    }

    public boolean realCanConstruct(String target, List<String> words) {
        return memoCanConstruct(target, words, new HashMap<String, Boolean>());
    }
    private boolean memoCanConstruct(String target, List<String> words, Map<String, Boolean> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.isEmpty()) return false;
        for (String word : words) {
            if (target.startsWith(word)) {
                boolean result = memoCanConstruct(target.substring(word.length()), words, memo);
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

    public boolean canConstructDP(String target, List<String> words) {
        boolean[] dp = new boolean[target.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= target.length(); i ++) {
            if (!dp[i]) continue;
            for (String word : words) {
                if (target.startsWith(word)) if (i + word.length() < dp.length) dp[i + word.length()] = true;
            }
        }
        return dp[target.length()];
    }

    /**
     * COUNT CONSTRUCT
     * @param target
     * @param words
     * @return
     */

    public int countConstruct(String target, List<String> words) {
        if (target.isEmpty()) return 1;
        int total = 0;
        for (String word : words) {
            if (target.startsWith(word)) {
                int rest = countConstruct(target.substring(word.length()), words);
                total += rest;
            }
        }
        return total;
    }

    public int memoCountConstruct(String target, List<String> words) {
        return countConstructMemo(target, words, new HashMap<String, Integer>());
    }
    private int countConstructMemo(String target, List<String> words, Map<String, Integer> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.isEmpty()) return 1;
        int total = 0;
        for (String word : words) {
            if (target.startsWith(word)) {
                int rest = countConstructMemo(target.substring(word.length()), words, memo);
                total += rest;
            }
        }
        memo.put(target, total);
        return total;
    }

    public int countConstructDP(String target, List<String> words) {
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        for (int i = 0; i < target.length(); i ++) dp.add(0);
        for (int i = 0; i < target.length(); i ++) {
            if (dp.get(i) == 0) continue;
            String curr = target.substring(i);
            for (String word : words) {
                if (curr.startsWith(word))
                    dp.set(i + word.length(),
                            dp.get(i) + dp.get(i + word.length()));
            }
        }
        return dp.get(target.length());
    }

    /**
     * ALL CONSTRUCT
     * @param target
     * @param words
     * @return
     */
    public List<List<String>> allConstruct(String target, List<String> words) {
        if (target.isEmpty()) return Arrays.asList(new ArrayList<>());
        List<List<String>> res = new ArrayList<>();
        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, words);
                suffixWays.forEach(way -> way.add(0, word));
                res.addAll(suffixWays);
            }
        }
        return res;
    }

    public List<List<String>> realAllConstruct(String target, List<String> words) {
        return allConstructMemo(target, words, new HashMap<String, List<List<String>>>());
    }
    private List<List<String>> allConstructMemo(String target, List<String> words, Map<String, List<List<String>>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.isEmpty()) return Arrays.asList(new ArrayList<>());
        List<List<String>> res = new ArrayList<>();
        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstructMemo(suffix, words, memo);
                suffixWays = suffixWays.stream()
                        .map(ArrayList::new)
                        .collect(toList());
                suffixWays.forEach(a -> a.add(0, word));
                res.addAll(suffixWays);
            }
        }
        memo.put(target, res);
        return res;
    }

}
