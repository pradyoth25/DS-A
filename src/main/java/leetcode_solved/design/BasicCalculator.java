package leetcode_solved.design;

import java.util.Stack;

public class BasicCalculator {

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
