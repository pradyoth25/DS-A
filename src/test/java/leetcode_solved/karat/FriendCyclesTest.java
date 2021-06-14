package leetcode_solved.karat;

import org.junit.Test;

import static org.junit.Assert.*;

public class FriendCyclesTest {

    FriendCycles code = new FriendCycles();

    @Test
    public void test() {
        String[] employees = new String[]{
                "1, Bill, Engineer",
                "2, Joe, HR",
                "3, Sally, Engineer",
                "4, Richard, Business",
                "6, Tom, Engineer"
        };
        String[] friendships = new String[]{
                "1, 2",
                "1, 3",
                "3, 4"
        };
        System.out.println(code.friendCycle1(employees, friendships));
    }

}