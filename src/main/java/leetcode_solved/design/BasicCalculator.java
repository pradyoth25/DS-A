package leetcode_solved.design;

import java.util.Stack;

public class BasicCalculator {

    /**
     * s consists of digits, '+', '-', '(', ')', and ' '.
     */
    public int basicCalculator(String s) {
        int num = 0, res = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * num; sign = 1; num = 0;
            } else if (c == '-') {
               res += sign * num; sign = -1; num = 0;
            } else if (c == '(') {
                stack.push(res); stack.push(sign);
                sign = 1; res = 0;
            } else if (c == ')') {
                res += sign * num; res *= stack.pop(); res += stack.pop();
                num = 0;
            }
        }
        return res + (sign * num);
    }

    /**
     * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
     */
    public int basicCalculator2(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(); int num = 0; char op = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1) {
                if (op == '-') stack.push( - num);
                else if (op == '+') stack.push(num);
                else if (op == '*') stack.push(stack.pop() * num);
                else if (op == '/') stack.push(stack.pop() / num);
                op = c; num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }

}
