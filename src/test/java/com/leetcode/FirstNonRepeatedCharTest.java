package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class FirstNonRepeatedCharTest {

    @Test
    public void firstNonRepeatedCharTest() {
        FirstNonRepeatedChar obj = new FirstNonRepeatedChar();

        String test = "shaiquse";


        Assert.assertEquals('h', obj.FirstNonRepeatedChar(test));
    }
}
