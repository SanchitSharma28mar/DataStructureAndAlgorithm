package com.datastructure.heap.impl;

import java.util.Arrays;
import java.util.List;

public class MaxHeap {
    private HeapNode[] heapArray;
    private int maxSize;
    private int currentSize;

    public MaxHeap(int size){
        this.heapArray = new HeapNode[size];
        this.maxSize = size;
        this.currentSize = 0;
    }

    public boolean isEmpty(){
        return this.currentSize == 0;
    }

    public boolean insert(int data) {
        if(currentSize == maxSize){
            return false;
        }

        HeapNode newNode = new HeapNode(data);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    private void trickleUp(int index) {
        int parentIndex = (index - 1)/2;
        HeapNode newlyAddedNode = heapArray[index];

        while(index > 0 && heapArray[parentIndex].getData() < newlyAddedNode.getData()) {
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex - 1)/2;
        }
        heapArray[index] = newlyAddedNode;
    }

    public HeapNode remove(){
        HeapNode removedNode = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return removedNode;
    }

    private void trickleDown(int index) {
        HeapNode node = heapArray[index];
        int largerChildIndex = 0;

        while(index < currentSize /2){
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            HeapNode leftChild = heapArray[leftChildIndex];
            HeapNode rightChild = heapArray[rightChildIndex];

            if(rightChildIndex < currentSize && rightChild.getData() > leftChild.getData())
                largerChildIndex = rightChildIndex;
            else
                largerChildIndex = leftChildIndex;

            if(node.getData() >= heapArray[largerChildIndex].getData())
                break;

            heapArray[index] = heapArray[largerChildIndex];
            index = largerChildIndex;
        }
        heapArray[index] = node;
    }

    public boolean changeValueAtIndex (int index, int newData){
        if(index < 0 || index >= currentSize)
            return false;

        int oldData = heapArray[index].getData();
        HeapNode nodeWithNewData = new HeapNode(newData);
        heapArray[index] = nodeWithNewData;

        if(oldData < newData)
            trickleUp(index);
        else
            trickleDown(index);

        return true;
    }

    public void printHeapArray(){
        List<HeapNode> list = Arrays.asList(heapArray);
        System.out.println(list);
    }
}
