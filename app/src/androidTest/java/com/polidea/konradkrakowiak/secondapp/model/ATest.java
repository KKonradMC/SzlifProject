package com.polidea.konradkrakowiak.secondapp.model;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.mockito.Mockito;

/**
 * Created by Konrad on 16/09/15.
 */
public class ATest extends TestCase {

    A a;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        a = new A();
        a.b = Mockito.mock(B.class);
    }

    public void testTest() {
        //when
        Mockito.when(a.b.getTest()).thenReturn("xxx");
        //then
        assert a.test() == "xxxtest";
    }

    public void testTest2() {
        //when
        Mockito.when(a.b.getTest()).thenReturn("xx2x");
        //then
        Assert.assertTrue(a.test() == "xx2xtest");
    }

    public void testTest3() {
        //when
        a.test();
        //then
        Mockito.verify(a.b.getTest(), Mockito.times(1));
    }


}