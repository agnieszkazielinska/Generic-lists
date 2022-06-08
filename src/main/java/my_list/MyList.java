package my_list;

public interface MyList {

    int size();
    int length();
    boolean isEmpty();
    boolean isNotEmpty();
    String[] toArray();
    boolean add(String s);
    boolean put(String s, int index);
    boolean remove(String s);
    boolean contain(String s);
    boolean containAll(String[] arr);
    boolean containAll(MyList list);
    boolean addAll (String[] arr);
    boolean addAll (MyList list);
    int indexOf(String s);
    String get (int index);
    int lastIndexOf(String s);
    MyList sublist (int fromIndex, int toIndex);
}
