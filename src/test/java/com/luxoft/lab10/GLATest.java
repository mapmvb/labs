package com.luxoft.lab10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GLATest {

    @Test
    void testInt(){
        Integer[] arrInt = {1,2,3,4,5,6,7,8,9};
        GenericListAggregator<Integer> massInt = new GenericListAggregator<>(arrInt);
        assertEquals(5.0, massInt.getAvgValue());
        assertEquals(9.0, massInt.getMaxValue());
        assertEquals(1.0, massInt.getMinValue());
    }
    @Test
    void testDouble(){
        Double[] arrD = {10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0};
        GenericListAggregator<Double> massD = new GenericListAggregator<>(arrD);
        assertEquals(50.0, massD.getAvgValue());
        assertEquals(90.0, massD.getMaxValue());
        assertEquals(10.0, massD.getMinValue());
    }

    @Test
    void testLong(){
        Long[] arrL = {100L,200L,300L,400L,500L,600L,700L,800L,900L};
        GenericListAggregator<Long> massL = new GenericListAggregator<>(arrL);
        assertEquals(500, massL.getAvgValue());
        assertEquals(900, massL.getMaxValue());
        assertEquals( 100, massL.getMinValue());
    }

    @Test
    void testByte(){
        Byte[] arrB ={1,2,3,4,5,6,7,8,9};
        GenericListAggregator<Byte> massB = new GenericListAggregator<>(arrB);
        assertEquals(5, massB.getAvgValue());
    }

    @Test
    void testShort(){
        Short[] arrS ={1,2,3,4,5,6,7,8,9};
        GenericListAggregator<Short> massS = new GenericListAggregator<>(arrS);
        assertEquals(5, massS.getAvgValue());
    }
}
