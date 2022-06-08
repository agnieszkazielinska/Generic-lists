package my_list.array_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgiStringArrayListImplAddTest {

    @Test
    public void shouldAddElementToList() {
        AgiStringArrayListImpl list = new AgiStringArrayListImpl(17);
        list.add("pimpek");
        list.add("pjes");
        list.add("wilczurek");

        assertEquals(3, list.length());
        assertEquals(17, list.size());
        assertEquals("pimpek", list.get(0));
    }

    @Test
    public void shouldAddElementToListWhenListIsShorter() {
        AgiStringArrayListImpl list = new AgiStringArrayListImpl(5);
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
    public void shouldTestIfContains() {
        AgiStringArrayListImpl wilczurkowie = new AgiStringArrayListImpl(4);
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Barnabasz");
        wilczurkowie.add("Chmurka");

        assertTrue(wilczurkowie.contain("Barnabasz"));
        assertFalse(wilczurkowie.contain("Adas"));
    }


    @Test
    public void shouldRemoveElementFromArray() {
        AgiStringArrayListImpl wilczurkowie = new AgiStringArrayListImpl(4);
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
    public void shouldGiveIndexOfString() {
        AgiStringArrayListImpl wilczurkowie = new AgiStringArrayListImpl(4);
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Chmurka");
        wilczurkowie.add("Barnabasz");


        assertEquals(3, wilczurkowie.indexOf("Barnabasz"));
        assertEquals(-1, wilczurkowie.indexOf("Adas"));
    }

    @Test
    public void shouldGiveLastIndexOfString() {
        AgiStringArrayListImpl wilczurkowie = new AgiStringArrayListImpl(6);
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Chmurka");
        wilczurkowie.add("Barnabasz");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Adas");

        assertEquals(4, wilczurkowie.lastIndexOf("Kacpi"));
    }

    //todo: podobny test dla metody public boolean containAll(MyList list);
    @Test
    public void shouldCheckIfContainsAll() {
        AgiStringArrayListImpl arr1 = new AgiStringArrayListImpl(6);
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


    //TODO: lista powinna byc samorozszeralna, jak dodasz wiecej elementow niz poczatkowy rozmiar to powinien sie zwiekszyc - dodac taki test
    @Test
    public void shouldAddAll() {
        AgiStringArrayListImpl arr1 = new AgiStringArrayListImpl(6);
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
    public void shouldGiveSublist() {
        AgiStringArrayListImpl arr1 = new AgiStringArrayListImpl(6);
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
    public void shouldCheckIfIsEmpty() {
        AgiStringArrayListImpl arr1 = new AgiStringArrayListImpl(6);
        arr1.add("A");
        arr1.add("F");
        arr1.add("D");
        arr1.add("C");
        arr1.add("B");
        arr1.add("G");

        assertFalse(arr1.isEmpty());

    }

    @Test
    public void shouldCheckIfIsNotEmpty() {
        AgiStringArrayListImpl arr1 = new AgiStringArrayListImpl(6);
        arr1.add("A");
        arr1.add("F");
        arr1.add("D");
        arr1.add("C");
        arr1.add("B");
        arr1.add("G");

        assertTrue(arr1.isNotEmpty());

    }

    @Test
    public void shouldCheckToArrayMethod() {


        AgiStringArrayListImpl list1 = new AgiStringArrayListImpl(9);
        list1.add("A");
        list1.add("F");
        list1.add("D");
        list1.add("C");
        list1.add("B");
        list1.add("G");


        var result = list1.toArray();
        assertTrue(result instanceof String[]);
        assertEquals(6,result.length );

    }

    @Test
    public void shouldCostamZeMniejIndeksow(){
        AgiStringArrayListImpl list1 = new AgiStringArrayListImpl(6);
        list1.add("A");
        list1.add("F");
        list1.add("D");
        list1.add("C");

        String[] wynik = list1.toArray();
        assertEquals(4, wynik.length);
    }

    @Test
    public void getTest(){
        AgiStringArrayListImpl list1 = new AgiStringArrayListImpl(4);
        list1.add("A");
        list1.add("F");
        list1.add("D");
        list1.add("C");

        assertEquals("F", list1.get(1));
    }
}
