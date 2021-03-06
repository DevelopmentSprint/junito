package com.developmentsprint.junito;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(OrderedJUnit4ClassRunner.class)
public class OrderMixedAnnotatedMethodsTest {

    private static int count = 0;

    @Test
    @Order(weight = -1)
    public void test1() {
        assertTrue(count == 0);
        count++;
    }

    @Test
    public void test5() {
        assertTrue(count > 2);
    }

    @Test
    @Order(weight = 1)
    public void test3() {
        assertTrue(count == 2);
        count++;
    }

    @Test
    public void test6() {
        assertTrue(count > 2);
    }

    @Test
    @Order(weight = 0)
    public void test2() {
        assertTrue(count == 1);
        count++;
    }

}
