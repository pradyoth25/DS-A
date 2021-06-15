package leetcode_solved.karat;

import org.junit.Test;

import java.util.List;

public class WrapLinesTest {

    WrapLines code = new WrapLines();

    @Test
    public void test() {
        String[] input = new String[]{"123 45 67 8901234 5678", "12345 8 9 0 1 23"};
        String[] input2 = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] input3 = new String[]{"123 45 67 8901234 5678", "12345 8 9 0 1 23"};
        int maxWidth = 10;
        List<String> res = code.wrapLines2(input, maxWidth);
        List<String> res2 = code.wrapLines2(input2, 16);
        System.out.println(res2);
        System.out.println(res);
        System.out.println(code.wrapLines2(input3, 15));
    }

    @Test
    public void test2() {
        String[] input = new String[]{"1p3acres", "is", "a", "good", "place", "to", "communicate"};
        System.out.println(code.wrapLines1(input, 12));
    }

}