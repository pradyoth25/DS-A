package leetcode_solved.karat;

import org.junit.Test;

public class CoursesTest {

    Courses code = new Courses();

    @Test
    public void test() {
        String[][] input = new String[][]{
                {"58", "Software Design"},
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
        };
        System.out.println(code.courses(input));
    }

}