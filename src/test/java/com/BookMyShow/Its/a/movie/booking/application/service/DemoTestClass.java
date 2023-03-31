package com.BookMyShow.Its.a.movie.booking.application.service;

import org.junit.jupiter.api.*;

public class DemoTestClass {
    @BeforeEach
    public void executeBeforeEachTest(){
        System.out.println("execute before each test");
    }
    @Test
    public void firstTest(){
        System.out.println("this is the first test");
    }
    @Test
    public void secondTest(){
        System.out.println("this is the second test");
    }
    @AfterEach
    public void executeAfterEachTest(){
        System.out.println("execute after each test");
    }
    @BeforeAll
    public static void beforeEverything(){
        System.out.println("Before Everything");
    }
    @AfterAll
    public static void afterEverything(){
        System.out.println("After Everything");
    }
    @Test
    public void assertionTest(){
   int expected=5;
   int actual=3+2;
   Assertions.assertEquals(expected,actual);
    }

}
