package leetcode_solved.karat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BadgeAccessTest {

    BadgeAccess code = new BadgeAccess();

    @Test
    public void test() {
        List<List<String>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList("Paul", "1355")));
        input.add(new ArrayList<>(Arrays.asList("Jennifer", "1910")));
        input.add(new ArrayList<>(Arrays.asList("John", "830")));
        input.add(new ArrayList<>(Arrays.asList("Paul", "1315")));
        input.add(new ArrayList<>(Arrays.asList("John", "835")));
        input.add(new ArrayList<>(Arrays.asList("Paul", "1405")));
        input.add(new ArrayList<>(Arrays.asList("Paul", "1630")));
        input.add(new ArrayList<>(Arrays.asList("John", "855")));
        input.add(new ArrayList<>(Arrays.asList("John", "915")));
        input.add(new ArrayList<>(Arrays.asList("John", "930")));
        input.add(new ArrayList<>(Arrays.asList("Jennifer", "1335")));
        input.add(new ArrayList<>(Arrays.asList("Jennifer", "730")));
        input.add(new ArrayList<>(Arrays.asList("John", "1630")));
        System.out.println(code.unusualAccess(input));
    }

    @Test
    public void test2() {
        String[][] input = new String[][] {
                {"James", "1300"}, {"Martha", "1600"}, {"Martha", "1620"}, {"Martha", "1530"}
        };
        System.out.println(code.frequentAccess(input));
    }

}