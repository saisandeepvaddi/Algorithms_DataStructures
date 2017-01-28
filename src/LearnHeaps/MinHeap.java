package LearnHeaps;

import java.util.Arrays;

/**
 * About the code :
 */
public class MinHeap {
    int capacity = 10;
    int size = 0;
    int[] items = new int[capacity];

    private int getParentIndex(int index) {
        return (int) (Math.ceil(((double) index - 2) / 2));
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private int getParent(int index) {
        return items[getParentIndex(index)];
    }

    private int getLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private void swap(int a, int b) {
        int tmp = items[a];
        items[a] = items[b];
        items[b] = tmp;
    }

    private void ensureExtraCapcity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChildIndex(index)) {
                smallerIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerIndex]) {
                break;
            } else {
                swap(index, smallerIndex);
            }
            index = smallerIndex;
        }

    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void add(int item) {
        ensureExtraCapcity();
        items[size] = item;
        size++;
        heapifyUp();
    }


}
