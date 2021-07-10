package leetcode_solved.karat;

import java.util.*;

public class KScratch {

    public List<String> lcs(String[] l1, String[] l2) {
        int m = l1.length, n = l2.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0, end = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (l1[i - 1].equals(l2[j - 1])) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        end = j;
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = end - 1; i >= end - max; i--) {
            res.add(l1[i]);
        }

        return res;
    }

    public List<List<List<Integer>>> findShapes(int[][] matrix) {
        List<List<List<Integer>>> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    List<List<Integer>> temp = new ArrayList<>();
                    dfs(matrix, i, j, temp);
                    res.add(new ArrayList<>(temp));
                }
            }
        }
        for (List<List<Integer>> t : res) {
            t.sort((a, b) -> {
                if (!a.get(0).equals(b.get(0))) return Integer.compare(a.get(0), b.get(0));
                else return Integer.compare(a.get(1), b.get(1));
            });
        }
        return res;
    }

    private void dfs(int[][] matrix, int i, int j, List<List<Integer>> temp) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 1) return;
        temp.add(new ArrayList<>(Arrays.asList(i, j)));
        matrix[i][j] = 1;
        dfs(matrix, i + 1, j, temp);
        dfs(matrix, i - 1, j, temp);
        dfs(matrix, i, j + 1, temp);
        dfs(matrix, i, j - 1, temp);
    }

    public List<String> wordWrap(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0, n = words.length;
        while (i < n) {
            if (sb.length() == 0) sb.append(words[i++]);
            else if (sb.length() + 1 + words[i].length() <= maxWidth) sb.append("-").append(words[i++]);
            else {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() != 0) res.add(sb.toString());
        return res;
    }

    public List<String> wordWrap2(String[] words, int maxWidth) {
        List<String> input = new ArrayList<>();
        for (String word : words) {
            String[] list = word.split("\\s");
            Collections.addAll(input, list);
        }
        words = input.toArray(new String[0]);
        List<String> res = new ArrayList<>();
        int i = 0, n = words.length;
        while (i < n) {
            int totalChars = words[i].length(), lastWord = i + 1;
            while (lastWord < n) {
                if (totalChars + 1 + words[lastWord].length() > maxWidth) break;
                totalChars += 1 + words[lastWord++].length();
            }
            int gaps = lastWord - i - 1;
            StringBuilder sb = new StringBuilder();
            if (gaps == 0 || lastWord == n) {
                for (int j = i; j < lastWord; j++) sb.append(words[j]).append("-");
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) sb.append("-");
            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int extra = (maxWidth - totalChars) % gaps;
                for (int j = i; j < lastWord - 1; j++) {
                    sb.append(words[j]).append("-");
                    int aSpaces = j - i < extra ? 1 : 0;
                    for (int k = 0; k < aSpaces + spaces; k++) sb.append("-");
                }
                sb.append(words[lastWord - 1]);
            }
            res.add(sb.toString());
            i = lastWord;
        }
        return res;
    }

    public int calc1(String input) {
        int num = 0, sign = 1, res = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            else if (c == '+' || c == '-') {
                res += (sign * num);
                num = 0;
                sign = c == '+' ? 1 : -1;
            }
        }
        return res + (sign * num);
    }

    public boolean isValidMatrix(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            Set<Integer> rSet = new HashSet<>(), cSet = new HashSet<>();
            int rMin = Integer.MAX_VALUE, rMax = Integer.MIN_VALUE;
            int cMin = rMin, cMax = rMax;
            for (int j = 0; j < m; j++) {
                if (rSet.contains(matrix[i][j])) return false;
                else {
                    rSet.add(matrix[i][j]);
                    rMin = Math.min(rMin, matrix[i][j]);
                    rMax = Math.max(rMax, matrix[i][j]);
                }

                if (cSet.contains(matrix[i][j])) return false;
                else {
                    cSet.add(matrix[i][j]);
                    cMax = Math.max(cMax, matrix[i][j]);
                    cMin = Math.min(cMin, matrix[i][j]);
                }
            }

            if (rMin != 1 || cMin != 1 || rMax != m || cMax != 1) return false;
        }
        return true;
    }

    public boolean isValidNonogram(int[][] matrix, int[][] rows, int[][] cols) {
        return isValidRows(matrix, rows) && isValidCols(matrix, cols);
    }

    private boolean isValidRows(int[][] matrix, int[][] rows) {
        for (int i = 0; i < matrix.length; i++) {
            int[] currRow = rows[i];
            int count = 0, cIndex = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (currRow.length == 0) return false;
                    count++;
                    if (count == currRow[cIndex]) {
                        if ((j == matrix[0].length - 1 || (j <= matrix[0].length - 2 && matrix[i][j + 1] == 1))) {
                            cIndex++;
                            count = 0;
                        } else {
                            return false;
                        }
                    }
                }
            }
            if (cIndex < currRow.length) return false;
        }
        return true;
    }

    private boolean isValidCols(int[][] matrix, int[][] cols) {
        for (int j = 0; j < matrix[0].length; j++) {
            int[] currCol = cols[j];
            int count = 0, cIndex = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 0) {
                    if (currCol.length == 0) return false;
                    count++;
                    if (count == currCol[cIndex]) {
                        if ((i == matrix.length - 1) || (i <= matrix.length - 2 && matrix[i + 1][j] == 1)) {
                            cIndex++;
                            count = 0;
                        } else {
                            return false;
                        }
                    }
                }
            }
            if (cIndex < currCol.length) return false;
        }
        return true;
    }

    public List<List<Integer>> lc1(int[][] pairs) {
        List<Integer> zero = new ArrayList<>(), ones = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : pairs) {
            int parent = p[0], child = p[1];
            map.put(child, map.getOrDefault(child, 0) + 1);
            map.put(parent, map.getOrDefault(parent, 0));
        }
        for (int node : map.keySet()) {
            if (map.get(node) == 0) zero.add(node);
            if (map.get(node) == 1) ones.add(node);
        }
        return new ArrayList<>(Arrays.asList(zero, ones));
    }

    public boolean lca2(int[][] pairs, int x, int y) {
        Set<Integer> p1 = new HashSet<>(), p2 = new HashSet<>();
        helperLCA(pairs, x, p1);
        helperLCA(pairs, y, p2);
        for (int parent : p2) {
            if (p1.contains(parent)) return true;
        }
        return false;
    }

    private void helperLCA(int[][] pairs, int node, Set<Integer> parents) {
        for (int[] pair : pairs) {
            int parent = pair[0], child = pair[1];
            if (child == node) {
                parents.add(parent);
                helperLCA(pairs, parent, parents);
            }
        }
    }

    protected static class SparseVector {
        Map<Integer, Double> map;
        int size;

        public SparseVector(int size) {
            this.size = size;
            this.map = new HashMap<>();
        }

        public void set(int index, double val) {
            if (index < 0 || index >= size) throw new RuntimeException("OOO");
            if (val == 0.0) map.remove(index);
            else map.put(index, val);
        }

        public double get(int index) {
            if (index < 0 || index >= size) throw new RuntimeException("OOO");
            return map.getOrDefault(index, 0.0);
        }

        public double dotProduct(SparseVector b) {
            SparseVector a = this;
            if (a.size != b.size) throw new RuntimeException("OOO");
            double sum = 0.0;
            for (Map.Entry<Integer, Double> e : a.map.entrySet()) {
                if (b.map.containsKey(e.getKey())) {
                    sum += a.get(e.getKey()) * b.get(e.getKey());
                }
            }
            return sum;
        }

        public SparseVector plus(SparseVector b) {
            SparseVector a = this;
            if (a.size != b.size) throw new RuntimeException("OOOO");
            SparseVector c = new SparseVector(a.size);
            for (Map.Entry<Integer, Double> e : a.map.entrySet()) {
                c.set(e.getKey(), a.get(e.getKey()));
            }
            for (Map.Entry<Integer, Double> e : b.map.entrySet()) {
                c.set(e.getKey(), c.get(e.getKey()) + b.get(e.getKey()));
            }
            return c;
        }
    }

}
