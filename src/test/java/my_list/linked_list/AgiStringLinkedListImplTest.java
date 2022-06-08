package my_list.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgiStringLinkedListImplTest {
    @Test
    public void shouldAddElementToList() {
        AgiStringLinkedListImpl list = new AgiStringLinkedListImpl();
        list.add("pimpek");
        list.add("pjes");
        list.add("wilczurek");

        assertEquals(3, list.length());
        assertEquals("pimpek", list.get(0));
    }

    @Test
    public void shouldCheckIfIsNotEmpty() {
        AgiStringLinkedListImpl arr1 = new AgiStringLinkedListImpl();
        arr1.add("A");
        arr1.add("F");
        arr1.add("D");
        arr1.add("C");
        arr1.add("B");
        arr1.add("G");

        assertTrue(arr1.isNotEmpty());

    }

    @Test
    public void shouldCheckIfIsEmpty() {
        AgiStringLinkedListImpl arr1 = new AgiStringLinkedListImpl();
        arr1.add("A");
        arr1.add("F");
        arr1.add("D");
        arr1.add("C");
        arr1.add("B");
        arr1.add("G");

        assertFalse(arr1.isEmpty());

    }

    @Test
    public void shouldCheckToArrayMethod() {


        AgiStringLinkedListImpl list1 = new AgiStringLinkedListImpl();
        list1.add("A");
        list1.add("F");
        list1.add("D");
        list1.add("C");
        list1.add("B");
        list1.add("G");


        var result = list1.toArray();
        assertTrue(result instanceof String[]);
        assertEquals(6, result.length);
    }

    @Test
    public void shouldTestIfContains() {
        AgiStringLinkedListImpl wilczurkowie = new AgiStringLinkedListImpl();
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Barnabasz");
        wilczurkowie.add("Chmurka");

        assertTrue(wilczurkowie.contain("Barnabasz"));
        assertFalse(wilczurkowie.contain("Adas"));
    }

    @Test
    public void shouldRemoveElementFromArray() {
        AgiStringLinkedListImpl wilczurkowie = new AgiStringLinkedListImpl();
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Chmurka");
        wilczurkowie.add("Barnabasz");

        wilczurkowie.remove("Chmurka");
        assertEquals(3, wilczurkowie.length());
        assertEquals("Barnabasz", wilczurkowie.get(2));

        wilczurkowie.remove("kid");
        assertFalse(wilczurkowie.remove("kid"));
        assertEquals(3, wilczurkowie.length());

    }

    @Test
    public void getTest(){
        AgiStringLinkedListImpl list1 = new AgiStringLinkedListImpl();
        list1.add("A");
        list1.add("F");
        list1.add("D");
        list1.add("C");

        assertEquals("F", list1.get(1));
        assertEquals("A", list1.get(0));
        assertEquals("C", list1.get(3));
    }

    @Test
    public void shouldGiveIndexOfString() {
        AgiStringLinkedListImpl wilczurkowie = new AgiStringLinkedListImpl();
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Chmurka");
        wilczurkowie.add("Barnabasz");


        assertEquals(3, wilczurkowie.indexOf("Barnabasz"));
        assertEquals(-1, wilczurkowie.indexOf("Adas"));
    }

    @Test
    public void shouldGiveLastIndexOfString() {
        AgiStringLinkedListImpl wilczurkowie = new AgiStringLinkedListImpl();
        wilczurkowie.add("Agi");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Chmurka");
        wilczurkowie.add("Barnabasz");
        wilczurkowie.add("Kacpi");
        wilczurkowie.add("Adas");

        assertEquals(4, wilczurkowie.lastIndexOf("Kacpi"));
    }
    @Test
    public void shouldCheckIfContainsAll() {
        AgiStringLinkedListImpl arr1 = new AgiStringLinkedListImpl();
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
        AgiStringLinkedListImpl arr1 = new AgiStringLinkedListImpl();
        arr1.add("X");
        arr1.add("A");
        arr1.add("B");
        arr1.add("C");

        AgiStringLinkedListImpl arr2 = new AgiStringLinkedListImpl();
        arr2.add("X");
        arr2.add("A");
        arr2.add("B");
        arr2.add("C");

        AgiStringLinkedListImpl arr3 = new AgiStringLinkedListImpl();
        arr3.add("S");
        arr3.add("A");
        arr3.add("B");
        arr3.add("C");

        assertFalse(arr1.containAll(arr3));
        assertTrue(arr1.containAll(arr2));
    }

    @Test
    public void shouldAddAll() {
        AgiStringLinkedListImpl arr1 = new AgiStringLinkedListImpl();
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
        AgiStringLinkedListImpl arr1 = new AgiStringLinkedListImpl();
        arr1.add("A");
        arr1.add("F");
        arr1.add("D");
        arr1.add("C");
        arr1.add("B");
        arr1.add("G");

        arr1.sublist(2, 4);


        assertEquals(3, arr1.length());

    }

    



}
