package plaid;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SampleTest {

    Sample sample = new Sample();

//    @Test
//    public void test_happyPath() {
//        sample.logHit(System.currentTimeMillis());
//        sample.logHit(System.currentTimeMillis());
//        assertEquals(sample.getHits(System.currentTimeMillis()), 2);
//    }
//
//    @Test
//    public void test_happyPathForZeroHits() {
//        sample.logHit(System.currentTimeMillis() - (10 * 60 * 1000));
//        sample.logHit(System.currentTimeMillis() - (10 * 60 * 1000));
//        assertEquals(sample.getHits(System.currentTimeMillis()), 0);
//    }
//
//    @Test
//    public void test_emptyInput() {
//        assertEquals(sample.getHits(System.currentTimeMillis()), 0);
//    }

    @Test
    public void test_cleanupCorrectly() {
        sample.logHit(101);
        sample.logHit(102);
        sample.logHit(99);
        sample.logHit(98);
        sample.logHit(97);
        assertEquals(sample.getHits(400), 2);
    }

}

