package com.test.q;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AssignmentTest {

    private Assignment assignment;
    private TranslateWord translateWordMock;

    @Before
    public void before() {
        translateWordMock = mock(TranslateWord.class);
        assignment = new Assignment(translateWordMock);
    }


    @Test
    public void testAssignmentShouldSuccess() {
        assignment.store("hello");
        assignment.store("hEllo");
        assignment.store("Hello");
        Assert.assertEquals(3, assignment.print("hello"));
    }

    @Test
    public void testAssignmentWhenStringNullShouldSuccessAndReturnZero() {
        assignment.store("");
        Assert.assertEquals(0, assignment.print(""));
    }

    @Test
    public void testAssignmentWithUsingShouldSuccess() {
        when(translateWordMock.translate(anyString())).thenReturn("Car", "Hello");
        assignment.store2("hello");
        assignment.store2("hEllo");
        assignment.store2("Cat");
        Assert.assertEquals(2, assignment.print2("hello"));
        verify(translateWordMock, times(3)).translate(anyString());
    }
}
