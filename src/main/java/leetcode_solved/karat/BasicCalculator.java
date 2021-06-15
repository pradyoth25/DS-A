package leetcode_solved.karat;

import java.util.Stack;

public class BasicCalculator {

    public int basicCalculator1(String s) {
        int num = 0, sign = 1, sum = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i ++) {
            char c = chs[i];
            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            else if (c == '+' || c == '-') {
                sum += (sign * num);
                num = 0;
                sign = c == '+' ? 1 : -1;
            }
        }
        if (num != 0) sum += (sign * num);
        return sum;
    }

    public int basicCalculator2(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0, sign = 1;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            else if (c == '+' || c == '-') {
                res += (sign * num);
                num = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += (sign * num);
                res *= stack.pop();
                res += stack.pop();
                num = 0;
            }
        }
        if (num != 0) res += (sign * num);
        return res;
    }

}
