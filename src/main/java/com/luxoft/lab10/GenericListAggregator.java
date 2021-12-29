package com.luxoft.lab10;

public class GenericListAggregator<T extends Number> {

    T[] arr;

    public GenericListAggregator(T[] arr) {
        this.arr = arr;
    }

    public double getAvgValue() {
        double total =0;
        int count = 0;
        for (T elem: arr) {
//            System.out.println("->"+arr);
            count++;
            total += elem.doubleValue();
        }
        return total/count;
    }

    public double getMaxValue(){
        double max = arr[0].doubleValue();
        for (T elem: arr             ) {
            if (elem.doubleValue() > max) {
                max = elem.doubleValue();
            }
        }
        return max;
    }
    public double getMinValue(){
        double min = arr[0].doubleValue();
        for (T elem: arr             ) {
            if (elem.doubleValue() < min) {
                min = elem.doubleValue();
            }
        }
        return min;
    }
}
