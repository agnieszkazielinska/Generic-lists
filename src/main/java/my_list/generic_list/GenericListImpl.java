package my_list.generic_list;

import java.util.Arrays;

public class GenericListImpl<T> implements GenericList<T> {

    private T[] agiArr;         //size to jest length tablicy, w przypadku tablicy size i length to to samo
    private int listLength;     //legnthList to ilosc aktualnie dodanych elementow do listy

    public GenericListImpl() {

        this.agiArr = (T[]) new Object[16];
        this.listLength = 0;
    }

    public GenericListImpl(int indexNumber) {
        this.agiArr = (T[]) new Object[indexNumber];
        this.listLength = 0;
    }

    private void recalculateListLength() {
        int numOfElements = 0;
        for (int i = 0; i < agiArr.length; i++) {
            if (agiArr[i] != null) {
                numOfElements++;
            }
        }
        listLength = numOfElements;

    }
    @Override
    public int size() {
        return agiArr.length;
    }

    @Override
    public int length() {
        return listLength;
    }

    @Override
    public boolean isEmpty() {
        if (listLength == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isNotEmpty() {
        if (listLength > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T[] toArray() {
        int nullsCounter = 0;
        for (int i = 0; i < agiArr.length; i++) {
            if (agiArr[i] == null) {
                nullsCounter++;
            }
        }
        T[] arrWithoutNulls = (T[]) new Object[agiArr.length - nullsCounter];

        int newIndex = 0;

        for (int i = 0; i < agiArr.length; i++) {

            if (agiArr[i] != null) {
                arrWithoutNulls[newIndex] = agiArr[i];
                newIndex++;
            }

        }
        return arrWithoutNulls;
    }

    @Override
    public boolean add(T element) {
        if (listLength < agiArr.length) {
            agiArr[listLength] = element;
            listLength++;

        } else {
            T[] newArr = (T[]) new Object[agiArr.length + 1];
            for (int i = 0; i < agiArr.length; i++) {
                newArr[i] = agiArr[i];
                newArr[newArr.length - 1] = element;
            }
            agiArr = newArr;
            listLength++;

        }
        return true;
    }

    @Override
    public boolean put(T element, int index) {
        if (index < agiArr.length && index >= 0) {
            agiArr[index] = element;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(T element) {
        if (contain(element)) {

            T[] newArr = (T[]) new Object[agiArr.length - 1];
            int index = 0;
            for (int i = 0; i < agiArr.length; i++) {
                if (agiArr[i] == element) {
                    index = i;
                }
            }
            for (int i = 0; i < index; i++) {
                newArr[i] = agiArr[i];
                break;
            }
            for (int i = index; i < newArr.length; i++) {
                newArr[i] = agiArr[i + 1];

            }
            agiArr = newArr;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contain(T element) {
        boolean tf = false;
        for (int i = 0; i < agiArr.length; i++) {
            if (agiArr[i] == element) {
                tf = true;
            }
        }
        return tf;
    }

    @Override
    public boolean containAll(T[] arr) {
        int n = arr.length;
        int m = agiArr.length;

        int i = 0;
        int j = 0;
        for (i = 0; i < n; i++) {

            //G -> [A,G,I,O,R]
            for (j = 0; j < m; j++) {
                if (arr[i].equals(agiArr[j])) {
                    break;
                }
            }
            if (j == m) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containAll(GenericList<T> list) {
        return containAll(list.toArray());
    }

    @Override
    public boolean addAll(T[] arr) {
        int a = agiArr.length;
        int b = arr.length;

        T[] finalArray = (T[]) new Object[a + b];

        System.arraycopy(agiArr, 0, finalArray, 0, a);
        System.arraycopy(arr, 0, finalArray, a, b);
        agiArr = finalArray;
        System.out.println(Arrays.toString(finalArray));
        System.out.println(Arrays.toString(agiArr));
        recalculateListLength();
        return true;
    }

    @Override
    public boolean addAll(GenericList<T> list) {
        return false;
    }

    @Override
    public int indexOf(T element) {
        int index = -1;
        for (int i = 0; i < agiArr.length; i++) {
            if (agiArr[i] == element) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public T get(int index) {
        return agiArr[index];
    }

    @Override
    public int lastIndexOf(T element) {
        int index = -1;
        if (contain(element)) {
            for (int i = agiArr.length - 1; i >= 0; i--) {
                if (agiArr[i].equals(element)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @Override
    public GenericList<T> sublist(int fromIndex, int toIndex) {
       T[] finalArr = (T[])new Object[toIndex - fromIndex + 1];
        System.arraycopy(agiArr, fromIndex, finalArr, 0, toIndex - fromIndex + 1);
        System.out.println(Arrays.toString(finalArr));
        agiArr = finalArr;
        recalculateListLength();

        return null;
    }
}
