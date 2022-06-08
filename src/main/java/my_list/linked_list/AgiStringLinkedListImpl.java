package my_list.linked_list;

import my_list.MyList;

import java.util.Objects;


public class AgiStringLinkedListImpl implements MyList {
    private Node head;
    private Node tail;
    private int length;

    AgiStringLinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public String[] toArray() {
        String[] arr = new String[length];
        Node n = head;
        for (int i = 0; i < arr.length; i++) {

            arr[i] = n.getValue();

            n = n.next();
        }
        return arr;
    }

    @Override
    public boolean add(String s) {
        Node newNode = new Node(s);

        //przypadek kiedy head i tail są nullami
        if (head == null && tail == null) {

            head = newNode;

            length++;

            //przypadek kiedy w headzie coś jest, a tail jest nullem
        } else if (head != null && tail == null) {
            tail = newNode;
            head.setNext(tail);
            length++;
        } else {
            tail.setNext(newNode);
            tail = newNode;
            length++;
        }


        //przypadek ogólny (kiedy w headzie i tailu już coś jest)


        return true;
    }

    @Override
    public boolean put(String s, int index) {
        if (index < length && index >= 0) {
            Node n = head;
            for (int i = 0; i < index; i++) {
                n.next();
            }
            n.setValue(s);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(String s) {
        Node n1 = head;
        if (contain(s)) {
            while (!(n1.next().getValue().equals(s))) {
                n1 = n1.next();
            }//tu znaleziony n1
//       Node n2 = n1.next();
            n1.setNext(n1.next().next());
            length--;
        } else {
            return false;
        }
        //PRZYKLAD :  head -> ... -> n1 -> n2 -> n3 -> ... -> tail [w przykladzie chcemy usuwac n2]

        //musimy znalezc poprzedniego w stosunku do usuwanego (poprzednik) - musimy znalezc n1 (***)
        //musimy rowniez znalezc nastepnika, (nastpnego po usunietym) - musimy znlezc n3

        //nastpenie zaczynamy zmiany:  caly n2 = null a nie tylko jego wartosc
        // nastepnie n1.setNext(n3) [zastepujemy next n1 jako n3 ("wypinamy z naszego pociagu n2")]
        // i to tyle w usuwaniu

        /*
        Ad (***)
        tak mozna znalezc poprzednik
        rozni sie tylko tym (jak nie rozumiesz to mozemy obgadac)
                    \/

        }

         */
        return true;
    }

    //wygalda git
    @Override
    public boolean contain(String s) {
        Node n = head;
        while (!n.getValue().equals(s)) {
            n = n.next();

            if (n == null) {
                return false;
            }
        }
        if (n.getValue() == s) {
            return true;
        }
        return false;
    }

    //giga git wyglada
    @Override
    public boolean containAll(String[] arr) {
        Node n = head;
        for (int i = 0; i < arr.length; i++) {
            while (!n.getValue().equals(arr[i])) {
                n = n.next();
                if (n == null) {
                    return false;
                }
                if (n.getValue().equals(arr[i])) {
                    break;
                }
            }

        }
        return true;

    }

    //tu musisz sie "nextami" iterowac(przechodzic) po liscie ktora dajesz jako argument, zaczynajac od jej heada
    @Override
    public boolean containAll(MyList list) {
      String[] arr = list.toArray();

      return containAll(arr);
    }

    //wygalda git
    @Override
    public boolean addAll(String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            tail.setNext(newNode);
            tail = newNode;
            length++;
        }
        return true;
    }

    //tu musisz sie "nextami" iterowac(przechodzic) po liscie ktora dajesz jako argument, zaczynajac od jej heada
    @Override
    public boolean addAll(MyList list) {
        String[] arr = list.toArray();
        return addAll(arr);

    }


    @Override
    public int indexOf(String s) {
        Node n = head;
        int licznikNode = 0;
        if (contain(s)) {
            while (!n.getValue().equals(s)) {
                n = n.next();
                licznikNode++;
            }
            return licznikNode;
        } else {
            return -1;
        }
    }

    //spoko
    @Override
    public String get(int index) {
        Node n = head;

        if (index > length) {
            throw new IllegalArgumentException("index nie moze byc poza rozmiarem listy");
        }


        for (int i = 0; i < index; i++) {

            n = n.next();
        }
        return n.getValue();

    }

    @Override
    public int lastIndexOf(String s) {
        Node n = head;
        int index = 0;
        int lastIndex = 0;

        if (contain(s)) {
            while (n != tail) {
                n = n.next();
                index++;
                if (Objects.equals(n.getValue(), s)) {
                    lastIndex = index;
                }
            }
        } else {
            lastIndex = -1;
        }
        return lastIndex;
    }

    @Override
    public MyList sublist(int fromIndex, int toIndex) {
        String[] finalArr = new String[toIndex - fromIndex + 1];
        int arrLength =0;
        for (int i = 0; i < finalArr.length; i++) {
            finalArr[i]=get(fromIndex);
            fromIndex++;
            arrLength++;

        }
        for (int i = 0; i < finalArr.length; i++) {
            System.out.println(finalArr[i]);
            length=arrLength;

        }
        return null;
    }

}
