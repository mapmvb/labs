package com.luxoft.lab7;

import com.luxoft.lab7.MvbArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MALTest {
    private static MvbArrayList<String> arl;

//    @BeforeAll
//    static void setUp() {
//        arl = new MvbArrayList<>();
//    }

    @Test
    void Test1() {
        arl = new MvbArrayList<>();
        arl.add("one");
        arl.add("two");
        assertEquals(2, arl.size());
        assertTrue(arl.get(0).equalsIgnoreCase("one"));

    }

    @Test
    void Test2() {
        int testLength = 100;
        arl = new MvbArrayList<>();
        for(int i = 0; i<testLength;i++){
            arl.add("I"+ ((Integer)i));
            if(i%20 == 0) System.out.println(arl);
        }
        assertEquals(arl.size(), testLength);
        assertTrue(arl.get(0).equalsIgnoreCase("I0"));
        System.out.println(arl.toString());

        assertTrue(arl.get(testLength-1).equalsIgnoreCase("I"+ ((Integer)(testLength-1))));

        for (int i=0;i<testLength-5;i++){
            arl.remove(0);
            if(i%20 == 0) System.out.println(arl);

        }
        assertEquals(5, arl.size());
        assertEquals(5,arl.size());
        System.out.println(arl.toString());

    }


}
