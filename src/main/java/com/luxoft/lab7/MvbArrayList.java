package com.luxoft.lab7;

public class MvbArrayList<T> {
    private final int INT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INT_SIZE];
    private int pointer = 0;

    public void add(T item) {
        if (pointer == array.length-1) {
            resize(array.length*2);
        }
        array[pointer++] = item;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array,0,newArray,0,pointer);
        array = newArray;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public int size() {
        return pointer;
    }

    public void remove(int index) {
        if (index >=0 && index < pointer ) {
            for (int i=index; i<pointer; i++) {
                array[i] = array[i+1];
            }
            array[pointer] = null;
            pointer--;
            if(array.length > INT_SIZE && pointer < array.length/CUT_RATE ) {
                resize(array.length/2);
            }
        }
    }
    @Override
    public String toString() {
        String rez = "MAL(max"+array.length+";curr"+pointer+"):";
        for(int i=0; i<pointer;i++) {
            rez+=array[i].toString() + " ";
            if ((i+1) % 30 == 0) {rez+="\n ";}
        }
        StringBuilder sb = new StringBuilder();
        sb.append("MAL(max").append(array.length).append(";curr").append(pointer).append("):");
        for(int i=0; i<pointer;i++) {
            sb.append(array[i].toString()).append(" ");
            if ((i + 1) % 30 == 0) {
                sb.append("\n ");
            }
        }
        return rez;
    }




}
