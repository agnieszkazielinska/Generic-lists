package my_list.array_list;

import my_list.MyList;

import java.lang.*;
import java.util.Arrays;

public class AgiStringArrayListImpl implements MyList {

    private String[] agiArr;  //size to jest length tablicy, w przypadku tablicy size i length to to samo
    private int listLength;   //legnthList to ilosc aktualnie dodanych elementow do listy

    public AgiStringArrayListImpl() {
        this.agiArr = new String[16];
        this.listLength = 0;
    }

    public AgiStringArrayListImpl(int indexNumber) {
        this.agiArr = new String[indexNumber];
        this.listLength = 0;
    }

    public String[] getAgiArr() {
        return agiArr;
    }

    public void setAgiArr(String[] agiArr) {
        this.agiArr = agiArr;
    }

    public int getListLength() {
        return listLength;
    }

    public void setListLength(int listLength) {
        this.listLength = listLength;
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
    public String[] toArray() {
        int nullsCounter = 0;
        for (int i = 0; i < agiArr.length; i++) {
            if (agiArr[i] == null) {
                nullsCounter++;
            }
        }
        String[] arrWithoutNulls = new String[agiArr.length - nullsCounter];

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
    public boolean add(String s) {

        if (listLength < agiArr.length) {
            agiArr[listLength] = s;
            listLength++;

        } else {
            String[] newArr = new String[agiArr.length + 1];
            for (int i = 0; i < agiArr.length; i++) {
                newArr[i] = agiArr[i];
                newArr[newArr.length - 1] = s;
            }
            agiArr = newArr;
            listLength++;

        }
        return true;
    }

    @Override
    public boolean put(String s, int index) {
        if (index < agiArr.length && index >= 0) {
            agiArr[index] = s;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(String s) {
        if (contain(s)) {

            String[] newArr = new String[agiArr.length - 1];
            int index = 0;
            for (int i = 0; i < agiArr.length; i++) {
                if (agiArr[i] == s) {
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
    public boolean contain(String s) {
        boolean tf = false;
        for (int i = 0; i < agiArr.length; i++) {
            if (agiArr[i] == s) {
                tf = true;
            }
        }
        return tf;
    }


    //    [A,G,I,O,R]
    // [G,O]
    @Override
    public boolean containAll(String[] arr) {
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
    public boolean containAll(MyList list) {
        return containAll(list.toArray());
    }

    @Override
    public boolean addAll(String[] arr) {
        int a = agiArr.length;
        int b = arr.length;

        String[] finalArray = new String[a + b];

        System.arraycopy(agiArr, 0, finalArray, 0, a);
        System.arraycopy(arr, 0, finalArray, a, b);
        agiArr = finalArray;
        System.out.println(Arrays.toString(finalArray));
        System.out.println(Arrays.toString(agiArr));
        recalculateListLength();
        return true;
    }

    @Override
    public boolean addAll(MyList list) {
        addAll(list.toArray());
        return true;
    }

    @Override
    public int indexOf(String s) {
        int index = -1;
        for (int i = 0; i < agiArr.length; i++) {
            if (agiArr[i] == s) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        return agiArr[index];
    }

    @Override
    public int lastIndexOf(String s) {
        int index = -1;
        if (contain(s)) {
            for (int i = agiArr.length - 1; i >= 0; i--) {
                if (agiArr[i].equals(s)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @Override
    public MyList sublist(int fromIndex, int toIndex) {
        String[] finalArr = new String[toIndex - fromIndex + 1];
        System.arraycopy(agiArr, fromIndex, finalArr, 0, toIndex - fromIndex + 1);
        System.out.println(Arrays.toString(finalArr));
        agiArr = finalArr;
        recalculateListLength();

        return null;
    }
}
