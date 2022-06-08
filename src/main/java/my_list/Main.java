package my_list;

import my_list.array_list.AgiStringArrayListImpl;

public class Main {

    public static void main(String[] args) {
        AgiStringArrayListImpl list = new AgiStringArrayListImpl();
        AgiStringArrayListImpl list2 = new AgiStringArrayListImpl(2);

        list.add("Agi");
        list.add("Kacpi");
        list.add("Hrapi");

        System.out.println(list.get(0));
        System.out.println(list.contain("Kacpi"));
        System.out.println(list.contain("Barnabasz"));
    }
}
