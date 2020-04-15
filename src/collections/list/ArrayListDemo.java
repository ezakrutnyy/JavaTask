package collections.list;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayListDemo {

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
    }
}


class MyArrayList<T> {

    private int size  = 0;

    private int capacity;

    private static  final int defaultCapacity = 3;

    T[] elementData;

    MyArrayList(int capacity) {
        this.capacity = capacity;
        elementData = (T[]) new Object[capacity];
    }

    MyArrayList() {
        this.capacity = defaultCapacity;
        elementData = (T[]) new Object[capacity];
    }

    public void add(T elem) {
        if (size >= capacity) createNewElementData();
        elementData[size++] = elem;
    }

    public T get(int index) {
        return elementData[index];
    }

    public T remove(int index) {

        T oldValue = elementData[index];

        int numMoved = size - index -1;

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
        int oldCapacity = this.capacity;
        int newCapacity = (oldCapacity*3)/2+1;
        this.capacity = newCapacity;

        T[] newElementData = (T[]) new Object[capacity];
        System.arraycopy(elementData,0, newElementData, 0, elementData.length);
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

    public class MyListIterator implements Iterator<T> {
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