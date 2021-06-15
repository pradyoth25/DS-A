package leetcode_solved.karat;

import org.junit.Test;

public class SparseVectorTest {

    @Test
    public void test() {
        int n = 70000;
        SparseVector A = new SparseVector(n);
        SparseVector B = new SparseVector(n);
        A.put(3, 1.0);
        A.put(2500, 6.3);
        A.put(60000, 5.7);
        A.put(5000, 10.0);
        B.put(1, 7.5);
        B.put(3, 5.7);
        B.put(2500, -6.3);
        B.put(234, 12.0);
        System.out.println("A dot B = " + A.dotProduct(B));
        System.out.println("A  +  B   = " + A.plus(B));
    }

}