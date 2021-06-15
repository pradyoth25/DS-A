package leetcode_solved.karat;

import java.util.Map;
import java.util.TreeMap;

public class SparseVector {

    TreeMap<Integer, Double> map;
    int size;

    public SparseVector(int size) {
        this.size = size;
        map = new TreeMap<>();
    }

    public void put(int i, double value) {
        if (i < 0 || i >= size) throw new RuntimeException("OOO");
        if (value == 0.0) map.remove(i);
        else map.put(i, value);
    }

    public double get(int i) {
        if (i < 0 || i >= size) throw new RuntimeException("OOO");
        return map.getOrDefault(i, 0.0);
    }

    public double dotProduct(SparseVector b) {
        SparseVector a = this;
        if (a.size != b.size) throw new RuntimeException("SIZE MISMATCH");
        double sum = 0;
        if (a.map.size() <= b.map.size()) {
            for (Map.Entry<Integer, Double> e : a.map.entrySet()) {
                if (b.map.containsKey(e.getKey())) {
                    sum += a.get(e.getKey()) * b.get(e.getKey());
                }
            }
        } else {
            for (Map.Entry<Integer, Double> e : b.map.entrySet()) {
                if (a.map.containsKey(e.getKey())) {
                    sum += a.get(e.getKey()) * b.get(e.getKey());
                }
            }
        }
        return sum;
    }

    public SparseVector plus(SparseVector b) {
        SparseVector a = this;
        if (a.size != b.size) throw new RuntimeException("SIZE MISMATCH");
        SparseVector c = new SparseVector(size);
        for (Map.Entry<Integer, Double> e : a.map.entrySet()) {
            c.put(e.getKey(), a.get(e.getKey()));
        }
        for (Map.Entry<Integer, Double> e : b.map.entrySet()) {
            c.put(e.getKey(), c.get(e.getKey()) + b.get(e.getKey()));
        }
        return c;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<Integer, Double> entry : map.entrySet())
            s.append("(").append(entry.getKey()).append(", ").append(map.get(entry.getKey())).append(") ");

        return s.toString();
    }

}
