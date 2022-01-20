package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class FirstRecurringCharacterTest {

    @Test
    public void firstRecurringCharacterTest() {
        FirstRecurringCharacter obj = new FirstRecurringCharacter();
        Assert.assertEquals('e', obj
        .firstRecurringCharacter("geeksforgeeks"));
    }
}
