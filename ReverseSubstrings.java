import java.util.Stack;

public class ReverseSubstrings {
    public static String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Precalculate matching bracket pairs
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int openIndex = stack.pop();
                pair[openIndex] = i;
                pair[i] = openIndex;
            }
        }

        // Step 2: Traverse string and reverse direction at parentheses
        StringBuilder result = new StringBuilder();
        int direction = 1;

        for (int i = 0; i < n; i += direction) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = pair[i];
                direction = -direction;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input1 = "(u(love)i)";
        String input2 = "(ed(et(oc)el)ec)";

        System.out.println("Input: " + input1 + " -> Output: " + reverseParentheses(input1));
        System.out.println("Input: " + input2 + " -> Output: " + reverseParentheses(input2));
    }
}