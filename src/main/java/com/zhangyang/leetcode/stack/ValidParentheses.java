package com.zhangyang.leetcode.stack;

/**
 * Created by yzhang on 2018/10/21.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */

import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) return false;
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charMap.values().contains(c)) {
                stack.push(c);
            } else {
                if (charMap.get(c).equals(stack.peek())) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
