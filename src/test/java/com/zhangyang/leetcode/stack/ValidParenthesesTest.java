package com.zhangyang.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by yzhang on 2018/10/21.
 */
@RunWith(Parameterized.class)
public class ValidParenthesesTest {
    private boolean expected;
    private String inputStr;

    public ValidParenthesesTest(boolean expected, String inputStr) {
        this.expected = expected;
        this.inputStr = inputStr;
    }


    @Test
    public void isValid() throws Exception {
        boolean valid = new ValidParentheses().isValid(inputStr);
        Assert.assertEquals(expected, valid);
    }

    @Parameters
    public static Collection initParam(){
        return Arrays.asList(new Object[][] {
                {true, ""},
                {true,"()"},
                {false,")"},
                {false,"("},
                {true,"()[]{}"},
                {false,"(]"},
                {false,"([)]"},
                {true,"{[]}"},
        });
    }

}