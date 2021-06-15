package leetcode_solved.karat;

import org.junit.Test;

import static org.junit.Assert.*;

public class DomainVisitsTest {

    DomainVisits code = new DomainVisits();

    @Test
    public void test() {
        String[] input1 = new String[]{"3234.html", "3235.html", "123.html" ,"xys.html", "t.html", "7hsaa.html", "sadasd.html"};
        String[] input2 = new String[]{"3234.html", "sdhsfjdsh.html", "123.html", "xys.html", "t.html", "7hsaa.html", "sadasd.html", "asdasd.html"};
        System.out.println(code.domainVisits2Dp(input1, input2));
    }

    @Test
    public void test2() {
        String[] input1 = new String[]{"3234.html", "3235.html", "123.html" ,"xys.html", "t.html", "7hsaa.html", "sadasd.html"};
        String[] input2 = new String[]{"3234.html", "sdhsfjdsh.html", "123.html", "xys.html", "t.html", "7hsaa.html", "sadasd.html", "asdasd.html"};
        System.out.println(code.domainVisits2Dp(input1, new String[0]));
    }

    @Test
    public void test3() {
        String[] input1 = new String[]{"3234.html", "3235.html", "123.html" ,"xys.html", "t.html", "7hsaa.html", "sadasd.html"};
        String[] input2 = new String[]{"323s4.html", "sdhsfjdsh.html", "1q23.html", "xysrr.html", "t.htqwml", "7hsaeqwea.html", "sasddasd.html", "asdasd.html"};
        System.out.println(code.domainVisits2Dp(input1, input2));
    }

    @Test
    public void test4() {
        String[] input1 = new String[]{"a.html", "b.html", "123.html" ,"xys.html", "t.html", "7hsaa.html", "sadasd.html"};
        String[] input2 = new String[]{"1.html", "a.html", "b.html", "xys.html", "t.html", "7hsaa.html", "sasddasd.html", "asdasd.html"};
        System.out.println(code.domainVisits2Dp(input1, input2));
    }


}