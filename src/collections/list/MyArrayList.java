package collections.list;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        list.remove(1);
        list.remove(2);
        list.remove(3);
        list.trimToSize();

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

//
//        for (Integer elem : list) {
//            System.out.println(elem);
//        }
    }

    private int size = 0;


    private static final int defaultCapacity = 3;

    private T[] elementData;

    MyArrayList(int capacity) {
        elementData = (T[]) new Object[capacity];
    }

    MyArrayList() {
        elementData = (T[]) new Object[defaultCapacity];
    }

    public boolean add(T elem) {
        if (size >= elementData.length) createNewElementData();
        elementData[size++] = elem;
        return true;
    }

    public T get(int index) {
        return elementData[index];
    }

    public T remove(int index) {

        T oldValue = elementData[index];

        int numMoved = size - index - 1;

        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        elementData[--size] = null;

        return oldValue;
    }

    public void trimToSize() {
        if (size < elementData.length) {
            elementData = Arrays.copyOf(elementData, size);
        }
    }

    private void createNewElementData() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        T[] newElementData = (T[]) new Object[newCapacity];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        this.elementData = newElementData;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < elementData.length; i++) {
            res += elementData[i];
        }
        return res;
    }

    public MyListIterator iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {

        private int top = 0;

        @Override
        public boolean hasNext() {
            return top < elementData.length;
        }

        @Override
        public T next() {
            return elementData[top++];
        }

        @Override
        public void remove() {

        }
    }
}