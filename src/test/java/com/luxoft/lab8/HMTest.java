package com.luxoft.lab8;

import com.luxoft.lab8.HashMapImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HMTest {
    private static HashMapImpl hashMap;

    @Test
    void TestHM(){
        hashMap = new HashMapImpl();
        int j = 1;
        String key;
        for(int i=0; i<45;i++) {
            Object rez;
            key = "Key"+i;
            rez = hashMap.put(key, "Val"+i);
            assertNull(rez);
            if(rez !=null){
                System.out.println("Dubl!");
            }
        }
//        System.out.println(hashMap.toString());

        assertEquals("Val29", hashMap.put("Key29", "Val129"));
        assertEquals("Val37", hashMap.put("Key37", "Val137"));
        assertEquals("Val7", hashMap.put("Key7", "Val117"));

        assertTrue(hashMap.containsKey("Key0"));
//        System.out.println(hashMap.toString());

        assertTrue(hashMap.containsKey("Key8"));
        assertTrue(hashMap.containsKey("Key13"));
        assertTrue(hashMap.containsValue("Val0"));
        assertTrue(hashMap.containsValue("Val117"));
        assertTrue(hashMap.containsValue("Val13"));
        assertFalse(hashMap.containsKey("Key55"));
        assertFalse(hashMap.containsValue("Val77"));

        assertEquals("Val2", hashMap.remove("Key2"));
        assertFalse(hashMap.containsKey("Key2"));
        assertEquals("Val18",hashMap.remove("Key18"));
        assertFalse(hashMap.containsKey("Key18"));
        assertEquals("Val44",hashMap.remove("Key44"));
        assertFalse(hashMap.containsKey("Key44"));
        assertNull(hashMap.remove("Key88"));

        hashMap.put("Key55", "Val55");
        assertTrue(hashMap.containsKey("Key55"));

        System.out.println(hashMap.toString());

        assertEquals("Val55", hashMap.get("Key55"));
        assertEquals("Val17", hashMap.get("Key17"));
        assertEquals("Val3", hashMap.get("Key3"));
        assertNull(hashMap.get("Key155"));

        System.out.println(hashMap.toString());



    }

}
