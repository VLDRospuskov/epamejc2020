package lessons.lesson14.example14;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static boolean checkParity(String expression,
                               String open, String close) {
        Stack stack = new Stack();
        StringTokenizer st
                = new StringTokenizer(expression, " \t\n\r+*/-(){}", true);
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            if (tmp.equals(open))
                stack.push(open);
            if (tmp.equals(close))
                stack.pop();
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(
                checkParity("a - (b - (c - a) / (b + c) - 2)", "(", ")"));
    }

}
