package test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MALTest {
//    private static test.java.MvbArrayList<String>;
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
        assertTrue(arl.size() == 2);
        assertTrue(arl.get(0).equalsIgnoreCase("one"));

    }

    @Test
    void Test2() {
        Integer testLength = 100;
        arl = new MvbArrayList<>();
        for(int i = 0; i<testLength;i++){
            arl.add("I"+((Integer)i).toString());
            if(i%20 == 0) System.out.println(arl);
        }
        assertTrue(arl.size() == testLength);
        assertTrue(arl.get(0).equalsIgnoreCase("I0"));
        System.out.println(arl.toString());

        assertTrue(arl.get(testLength-1).equalsIgnoreCase("I"+((Integer)(testLength-1)).toString()));

        for (int i=0;i<testLength-5;i++){
            arl.remove(0);
            if(i%20 == 0) System.out.println(arl);

        }
        assertTrue(arl.size() == 5);
        assertEquals(arl.size(),5);
        System.out.println(arl.toString());

    }


}
