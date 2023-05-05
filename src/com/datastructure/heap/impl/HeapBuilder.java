package com.datastructure.heap.impl;

public class HeapBuilder {

    public static MaxHeap maxHeap(){
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(70);
        maxHeap.insert(40);
        maxHeap.insert(50);
        maxHeap.insert(20);
        maxHeap.insert(60);
        maxHeap.insert(100);
        maxHeap.insert(80);
        maxHeap.insert(30);
        maxHeap.insert(10);
        maxHeap.insert(90);
        return maxHeap;
    }
}
