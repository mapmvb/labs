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
        for(int i=0; i<40;i++) {
            Object rez;
            key = "Key"+i;
            rez = hashMap.put(key, "Val"+i);
            if(rez !=null){
                System.out.println("Dubl!");
            }
        }
        System.out.println(hashMap.toString());

        assertTrue(hashMap.containsKey("Key0"));
        assertTrue(hashMap.containsKey("Key8"));
        assertTrue(hashMap.containsKey("Key13"));
        assertTrue(hashMap.containsValue("Val0"));
        assertTrue(hashMap.containsValue("Val7"));
        assertTrue(hashMap.containsValue("Val13"));
        assertFalse(hashMap.containsKey("Key55"));
        assertFalse(hashMap.containsValue("Val77"));

        hashMap.remove("Key8");
        assertFalse(hashMap.containsKey("Key8"));

        hashMap.put("Key55", "Val55");
        assertTrue(hashMap.containsKey("Key55"));

        System.out.println(hashMap.toString());



    }

}
