package my_list.generic_list;

public interface GenericList <T>{
    int size();
    int length();
    boolean isEmpty();
    boolean isNotEmpty();
    Object[] toArray();
    boolean add(T element);
    boolean put(T element, int index);
    boolean remove(T element);
    boolean contain(T element);
    boolean containAll(T[] arr);
    boolean containAll(GenericList<T> list);
    boolean addAll (T[] arr);
    boolean addAll (GenericList<T> list);
    int indexOf(T element);
    T get (int index);
    int lastIndexOf(T element);
    GenericList<T> sublist (int fromIndex, int toIndex);
}
