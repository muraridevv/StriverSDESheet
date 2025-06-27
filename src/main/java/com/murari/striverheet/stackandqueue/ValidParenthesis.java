package com.murari.striverheet.stackandqueue;

import java.util.Stack;

public class ValidParenthesis {

  public boolean isValid(String s) {
    // Create a Stack to store opening brackets
    Stack<Character> stack = new Stack<>();

    for (char ch : s.toCharArray()) {
      if (ch == '{' || ch == '[' || ch == '(') {
        stack.push(ch);
      } else {

        // If the ch is closing bracket
        // Check if the stack is empty or if the top element of stack doesn't match the
        // corresponding bracket
        if (stack.isEmpty() || !isValidPair(stack.pop(), ch)) {
          return false;
        }
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  private boolean isValidPair(char open, char close) {
    return (open == '(' && close == ')')
        || (open == '[' && close == ']')
        || (open == '{' && close == '}');
  }

  public static void main(String[] args) {
    ValidParenthesis solution = new ValidParenthesis();
    // Test cases
    String s1 = "()";
    String s2 = "()[]{}";
    String s3 = "(]";
    String s4 = "([)]";
    String s5 = "{[]}";

    System.out.println("Is '" + s1 + "' valid? " + solution.isValid(s1));
    System.out.println("Is '" + s2 + "' valid? " + solution.isValid(s2));
    System.out.println("Is '" + s3 + "' valid? " + solution.isValid(s3));
    System.out.println("Is '" + s4 + "' valid? " + solution.isValid(s4));
    System.out.println("Is '" + s5 + "' valid? " + solution.isValid(s5));
  }
}
