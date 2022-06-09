package my_list.generic_list;

import my_list.array_list.AgiStringArrayListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericListImplTest {
    @Test
    public void shouldAddStringToList() {
        GenericListImpl<String> list = new GenericListImpl<>(17);
        list.add("pimpek");
        list.add("pjes");
        list.add("wilczurek");

        assertEquals(3, list.length());
        assertEquals(17, list.size());
        assertEquals("pimpek", list.get(0));
    }
    @Test
    public void shouldAddIntToList() {
        GenericListImpl<Integer> list = new GenericListImpl<>(17);
        list.add(5);
        list.add(4);
        list.add(8);

        assertEquals(3, list.length());
        assertEquals(17, list.size());
        assertEquals(5, list.get(0));
    }

    @Test
    public void shouldAddStringToListWhenListIsShorter() {
        GenericListImpl<String> list = new GenericListImpl<>(5);
        list.add("pimpek");
        list.add("pjes");
        list.add("wilczurek0");
        list.add("wilczurek1");
        list.add("wilczurek2");
        list.add("wilczurek3");
        list.add("wilczurek4");

        assertEquals(7, list.length());
        assertEquals(7, list.size());
        assertEquals("pimpek", list.get(0));
        assertEquals("wilczurek4", list.get(list.length() - 1));
    }

    @Test
    public void shouldAddIntToListWhenListIsShorter() {
        GenericListImpl<Integer> list = new GenericListImpl<>(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        assertEquals(7, list.length());
        assertEquals(7, list.size());
        assertEquals(1, list.get(0));
        assertEquals(7, list.get(list.length() - 1));
    }

    @Test
    public void shouldCheckIfIsEmptyString() {
        GenericListImpl<String> arr1 = new GenericListImpl<>(6);
        arr1.add("A");
        arr1.add("F");
        arr1.add("D");
        arr1.add("C");
        arr1.add("B");
        arr1.add("G");

        assertFalse(arr1.isEmpty());

    }

    @Test
    public void shouldCheckIfIsEmptyInt() {
        GenericListImpl<Integer> arr1 = new GenericListImpl<>(6);
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        arr1.add(6);

        assertFalse(arr1.isEmpty());
    }

    @Test
    public void shouldCheckIfIsNotEmptyInt() {
        GenericListImpl<Integer> arr1 = new GenericListImpl<>(6);
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        arr1.add(6);

        assertTrue(arr1.isNotEmpty());

    }

    @Test
    public void shouldCheckToArrayMethodString() {


        GenericListImpl<String> list1 = new GenericListImpl<>(9);
        list1.add("A");
        list1.add("F");
        list1.add("D");
        list1.add("C");
        list1.add("B");
        list1.add("G");


        var result = list1.toArray();
        assertTrue(result instanceof Object[]);
        assertEquals(6,result.length );

    }

    @Test
    public void shouldCheckToArrayMethodInt() {


        GenericListImpl<Integer> list1 = new GenericListImpl<>(9);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);


        var result = list1.toArray();
        assertTrue(result instanceof Object[]);
        assertEquals(6,result.length );

    }

    @Test
    public void shouldPutStringIntoIndex(){
        GenericListImpl<String> list = new GenericListImpl<>(4);
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        list.put("X", 2);

        assertEquals("X", list.get(2));
    }
    @Test
    public void shouldPutIntIntoIndex(){
        GenericListImpl<Integer> list = new GenericListImpl<>(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.put(9, 2);

        assertEquals(9, list.get(2));
    }

    @Test
    public void shouldRemoveStringFromArray() {
        GenericListImpl<String> wilczurkowie = new GenericListImpl<>(4);
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Chmurka");
        wilczurkowie.add("Barnabasz");

        wilczurkowie.remove("Chmurka");

        assertEquals(4, wilczurkowie.length());
        assertEquals(3, wilczurkowie.size());
        assertEquals("Barnabasz", wilczurkowie.get(2));

        wilczurkowie.remove("kid");
        assertFalse(wilczurkowie.remove("kid"));
        assertEquals(4, wilczurkowie.length());
        assertEquals(3, wilczurkowie.size());
    }
    @Test
    public void shouldTestIfContainsString() {
        GenericListImpl<String> wilczurkowie = new GenericListImpl<>(4);
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Barnabasz");
        wilczurkowie.add("Chmurka");

        assertTrue(wilczurkowie.contain("Barnabasz"));
        assertFalse(wilczurkowie.contain("Adas"));
    }

    @Test
    public void shouldTestIfContainsInt() {
        GenericListImpl<Integer> wilczurkowie = new GenericListImpl<>(4);
        wilczurkowie.add(1);
        wilczurkowie.add(2);
        wilczurkowie.add(3);
        wilczurkowie.add(4);

        assertTrue(wilczurkowie.contain(3));
        assertFalse(wilczurkowie.contain(7));
    }

    @Test
    public void shouldCheckIfContainsAllString() {
        GenericListImpl<String> arr1 = new GenericListImpl<>(6);
        arr1.add("X");
        arr1.add("A");
        arr1.add("B");
        arr1.add("C");



        String[] arr4 = {"A", "B", "Z"};
        String[] arr5 = {"A", "B", "C"};


        assertFalse(arr1.containAll(arr4));
        assertTrue(arr1.containAll(arr5));
    }

    @Test
    public void shouldCheckIfContainsAllFromList() {
        AgiStringArrayListImpl arr1 = new AgiStringArrayListImpl(6);
        arr1.add("X");
        arr1.add("A");
        arr1.add("B");
        arr1.add("C");

        AgiStringArrayListImpl arr2 = new AgiStringArrayListImpl(6);
        arr2.add("X");
        arr2.add("A");
        arr2.add("B");
        arr2.add("C");

        AgiStringArrayListImpl arr3 = new AgiStringArrayListImpl(6);
        arr3.add("S");
        arr3.add("A");
        arr3.add("B");
        arr3.add("C");

        assertFalse(arr1.containAll(arr3));
        assertTrue(arr1.containAll(arr2));
    }
    @Test
    public void shouldAddAll() {
        GenericListImpl<String> arr1 = new GenericListImpl<>(6);
        arr1.add("A");
        arr1.add("F");
        arr1.add("D");
        arr1.add("C");
        arr1.add("B");
        arr1.add("G");

        String[] arr3 = {"X", "Y", "Z"};

        arr1.addAll(arr3);


        assertEquals(9, arr1.length());
        assertEquals("X", arr1.get(6));


    }
    @Test
    public void shouldAddAllInt() {
        GenericListImpl<Integer> arr1 = new GenericListImpl<>(6);
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        arr1.add(6);

        Integer[] arr3 = {7, 8, 9};

        arr1.addAll(arr3);


        assertEquals(9, arr1.length());
        assertEquals(7, arr1.get(6));


    }

    @Test
    public void shouldGiveIndexOfString() {
        GenericListImpl<String> wilczurkowie = new GenericListImpl<>(4);
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Chmurka");
        wilczurkowie.add("Barnabasz");


        assertEquals(3, wilczurkowie.indexOf("Barnabasz"));
        assertEquals(-1, wilczurkowie.indexOf("Adas"));
    }

    @Test
    public void shouldGiveIndexOfInt() {
        GenericListImpl<Integer> wilczurkowie = new GenericListImpl<>(4);
        wilczurkowie.add(1);
        wilczurkowie.add(2);
        wilczurkowie.add(3);
        wilczurkowie.add(4);


        assertEquals(3, wilczurkowie.indexOf(4));
        assertEquals(-1, wilczurkowie.indexOf(9));
    }

    @Test
    public void shouldGiveLastIndexOfString() {
        GenericListImpl<String> wilczurkowie = new GenericListImpl<>(6);
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Chmurka");
        wilczurkowie.add("Barnabasz");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Adas");

        assertEquals(4, wilczurkowie.lastIndexOf("Kacpi"));
    }
    @Test
    public void shouldGiveLastIndexOfInt() {
        GenericListImpl<Integer> wilczurkowie = new GenericListImpl<>(6);
        wilczurkowie.add(1);
        wilczurkowie.add(2);
        wilczurkowie.add(3);
        wilczurkowie.add(4);
        wilczurkowie.add(2);
        wilczurkowie.add(6);

        assertEquals(4, wilczurkowie.lastIndexOf(2));
    }

    @Test
    public void shouldGiveSublist() {
        GenericListImpl<String> arr1 = new GenericListImpl(6);
        arr1.add("A");
        arr1.add("F");
        arr1.add("D");
        arr1.add("C");
        arr1.add("B");
        arr1.add("G");

        arr1.sublist(2, 4);

        for (int i = 0; i < arr1.length(); i++) {
            System.out.println(arr1.get(i));

        }
        assertEquals(3, arr1.length());

    }
    @Test
    public void shouldGiveSublistInt() {
        GenericListImpl<Integer> arr1 = new GenericListImpl(6);
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        arr1.add(6);

        arr1.sublist(2, 4);

        for (int i = 0; i < arr1.length(); i++) {
            System.out.println(arr1.get(i));

        }
        assertEquals(3, arr1.length());

    }

}