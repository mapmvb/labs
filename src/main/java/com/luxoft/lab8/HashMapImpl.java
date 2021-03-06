package com.luxoft.lab8;

import java.util.HashMap;

public class HashMapImpl {
    private float loadFactor = 0.75f;
    private int capasity = 10;
    private int size = 0;
    private Entry[] table = new Entry[capasity];

    private int hashing(int hashCod){
        int plase = hashCod % capasity;
//        System.out.println("Bucket#"+ Math.abs(plase));
        return Math.abs(plase);
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean containsKey(Object key){
        Entry entry;
        int place = hashing(key.hashCode());
        entry = table[place];
        while (entry!= null){
            if(key.equals(entry.getKey())) {
                return true;
            } else {
                entry = entry.getNext();
            }
        }
        return false;
    }

    public boolean containsValue(Object value){
        Entry entry;
        for (Entry item : table) {
            entry = item;
            while (entry != null) {
                if (value.equals(entry.getVal())) {
                    return true;
                } else {
                    entry = entry.getNext();
                }
            }
        }
        return false;
    }

    public Object put(Object key, Object val) {
        Object rez = null;
        Entry newEntry, curEntry;
//        String skey =(String)key;
//        System.out.print("k="+skey);
        int place = hashing(key.hashCode());
//        System.out.println(" hash= "+key.hashCode()+" Place="+place);
        curEntry = table[place];
        while (curEntry != null ) {
            if(key.equals(curEntry.getKey())) {
                rez = curEntry.getVal();
                System.out.println("k="+key+"   Val=" + rez);
                curEntry.setKey(key);
                curEntry.setVal(val);
                return rez;
            } else {
                if(curEntry.getNext() != null) {
                    curEntry = curEntry.getNext();
                } else {
                    newEntry =new Entry(key,val,null);
                    curEntry.setNext(newEntry);
                    return null;
                }
            }
        }
        newEntry =new Entry(key,val,null);
        table[place] = newEntry;
        return rez;
    }

    public Object get(Object key){
        Object ret = null;
        Entry entry;
        int place = hashing(key.hashCode());
        entry =table[place];
        while (entry != null) {
            if (key.equals(entry.getKey())){
                ret = entry.getVal();
                return ret;
            } else {
                entry = entry.getNext();
            }
        }
        return ret;
    }

    public Object remove(Object key){
        Object ret = null;
        Entry entry;
        Entry prevEntry = null;
        int place = hashing(key.hashCode());
        entry = table[place];

        while (entry!= null){
            if(key.equals(entry.getKey())) {
                ret = entry.getVal();
                if (prevEntry == null){
                    table[place] = entry.getNext();
                } else {
                    prevEntry.setNext(entry.getNext());
                }
                entry = null;
            } else {
                prevEntry = entry;
                entry = entry.getNext();
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        Entry entry;
        for(int i=0; i<capasity;i++) {
            entry = table[i];
//            System.out.print("E"+i+"=");
            while (entry != null){
                ret.append(" ???").append(i).append(" K=").append(entry.getKey()).append(" V=").append(entry.getVal()).append("\n");
                entry = entry.getNext();
//                System.out.println("not null!");
//            } else {
//                System.out.println("   null");

            }

        }
        return ret.toString();
    }
}
