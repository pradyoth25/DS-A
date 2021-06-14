package leetcode_solved.karat;

import org.junit.Test;

import static org.junit.Assert.*;

public class DomainVisitsTest {

    DomainVisits code = new DomainVisits();

    @Test
    public void test() {
        String[] input1 = new String[]{"3234.html", "3235.html", "123.html" ,"xys.html", "t.html", "7hsaa.html", "sadasd.html"};
        String[] input2 = new String[]{"3234.html", "sdhsfjdsh.html", "123.html", "xys.html", "t.html", "7hsaa.html", "sadasd.html", "asdasd.html"};
        System.out.println(code.domainVisits2(input1, input2));
    }


}