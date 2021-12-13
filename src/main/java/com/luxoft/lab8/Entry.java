package com.luxoft.lab8;

public class Entry {
    Object key;
    Object val;
    Entry next;

    public Entry() {
        this(null,null,null);
    }

    public Entry(Object key, Object val, Entry next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return key.equals(entry.key);
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int mul = 11;
        if(key !=null) {
            return prime*mul + key.hashCode();
        }
        return 0;
    }
}
