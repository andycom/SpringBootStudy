package com.fancv.collection;

import java.util.*;

/**
 *
 */
public class MyHashMap {
    public static void main(String args[]) {
        Map<String, String> my = new HashMap();


        my.put("1", "hello");
        my.put("2", "word");
        my.put(null, "null");
        my.put("atatatatatatatatatatat", "hash1");
        my.put("atatatatatatatatbUbUat", "hash2");
        my.put("atatatatatatatatatbUat", "hash3");
        my.put("atatatatatatatatatatc6", "hash4");
        my.put("atatatatatatatatatbUat", "hash5");
        my.put("atatatatatatatatatc6c6", "hash6");
        my.put("atatatatatatatatbUatc6", "hash7");
        my.put("atatatatatatatatbUbUc6", "hash8");
        my.put("atatatatatatatatatatbU", "hash9");
        my.put("atatatatatatatatbUc6at", "hash10");
        my.put("atatatatatatatatbUbUc6", "hash11");
        my.put("xwxwxwxwxwxwxwyXz9yXyX", "21");
        my.put("xwxwxwxwxwxwxwyXz9yXz9", "value22");
        my.put("xwxwxwxwxwxwxwyXz9z9xw", "val2ue34");
        my.put("xwxwxwxwxwxwxwyXz9z9yX", "100");
        my.put("xwxwxwxwxwxwxwyXz9z9z9", "101");
        my.put("xwxwxwxwxwxwxwz9xwxwxw", "102");
        my.put("xwxwxwxwxwxwxwz9xwxwyX", "value103");
        my.put("xwxwxwxwxwxwxwz9xwxwz9", "value104");
        my.put("xwxwxwxwxwxwxwz9xwyXxw", "value105");
        my.put("xwxwxwxwxwxwxwz9xwyXyX", "value105");
        my.put("xwxwxwxwxwxwxwz9xwyXz9", "value106");
        my.put("xwxwxwxwxwxwxwz9xwz9xw", "value107");
        my.put("xwxwxwxwxwxwxwz9xwz9yX", "value107");
        my.put("xwxwxwxwxwxwxwz9xwz9z9", "value108");
        my.put("xwxwxwxwxwxwxwz9yXxwxw", "value109");
        my.put("xwxwxwxwxwxwxwz9yXxwyX", "value111");
        my.put("xwxwxwxwxwxwxwz9yXxwz9", "value112");
        my.put("xwxwxwxwxwxwxwz9yXyXxw", "value114");
        my.put("xwxwxwxwxwxwxwz9yXyXyX", "value115");
        my.put("xwxwxwxwxwxwxwz9yXyXz9", "value116");
        my.put("xwxwxwxwxwxwxwz9yXz9xw", "value117");
        my.put("xwxwxwxwxwxwxwz9yXz9yX", "value121");
        my.put("xwxwxwxwxwxwxwz9yXz9z9", "value122");
        my.put("xwxwxwxwxwxwxwz9z9xwxw", "value123");
        my.put("xwxwxwxwxwxwxwz9z9xwyX", "value124");
        my.put("xwxwxwxwxwxwxwz9z9xwz9", "value125");
        my.put("xwxwxwxwxwxwxwz9z9yXxw", "value126");
        my.put("xwxwxwxwxwxwxwz9z9yXyX", "value133");
        my.put("xwxwxwxwxwxwxwz9z9yXz9", "value131");
        my.put("xwxwxwxwxwxwxwz9z9z9xw", "value132");
        my.put("xwxwxwxwxwxwxwz9z9z9yX", "value134");
        my.put("xwxwxwxwxwxwxwz9z9z9z9", "value135");
        my.put("xwxwxwxwxwxwyXxwxwxwxw", "value141");
        my.put("xwxwxwxwxwxwyXxwxwxwyX", "value142");
        my.put("xwxwxwxwxwxwyXxwxwxwz9", "value143");
        my.put("xwxwxwxwxwxwyXxwxwyXxw", "value145");
        my.put("xwxwxwxwxwxwyXxwxwyXyX", "value151");
        my.put("xwxwxwxwxwxwyXxwxwyXz9", "value152");
        my.put("xwxwxwxwxwxwyXxwxwz9xw", "value153");
        my.put("xwxwxwxwxwxwyXxwxwz9yX", "value154");
        my.put("xwxwxwxwxwxwyXxwxwz9z9", "value155");
        my.put("xwxwxwxwxwxwyXxwyXxwxw", "value211");
        my.put("xwxwxwxwxwxwyXxwyXxwyX", "value212");
        my.put("xwxwxwxwxwxwyXxwyXxwz9", "value312");
        my.put("xwxwxwxwxwxwyXxwyXyXxw", "value321");
        my.put("xwxwxwxwxwxwyXxwyXyXyX", "value333");
        my.put("xwxwxwxwxwxwyXxwyXyXz9", "value331");
        my.put("xwxwxwxwxwxwyXxwyXz9xw", "value332");
        my.put("xwxwxwxwxwxwyXxwyXz9yX", "value335");
        my.put("xwxwxwxwxwxwyXxwyXz9z9", "value225");
        my.put("xwxwxwxwxwxwyXxwz9xwxw", "value334");
        my.put("xwxwxwxwxwxwyXxwz9xwyX", "value411");
        my.put("xwxwxwxwxwxwyXxwz9xwz9", "value412");
        my.put("xwxwxwxwxwxwyXxwz9yXxw", "value421");
        my.put("xwxwxwxwxwxwyXxwz9yXyX", "value431");
        my.put("xwxwxwxwxwxwyXxwz9yXz9", "value422");
        my.put("xwxwxwxwxwxwyXxwz9z9xw", "value433");
        my.put("xwxwxwxwxwxwyXxwz9z9yX", "value3333");
        my.put("xwxwxwxwxwxwyXxwz9z9z9", "value33234");
        my.put("xwxwxwxwxwxwyXyXxwxwxw", "value2342");
        my.put("xwxwxwxwxwxwyXyXxwxwyX", "value134");
        my.put("xwxwxwxwxwxwyXyXxwxwz9", "value312341");
        my.put("xwxwxwxwxwxwyXyXxwyXxw", "value34535");
        my.put("xwxwxwxwxwxwyXyXxwyXyX", "value34532");
        my.put("xwxwxwxwxwxwyXyXxwyXz9", "value254235");
        my.put("xwxwxwxwxwxwyXyXxwz9xw", "value23452");
        my.put("xwxwxwxwxwxwyXyXxwz9yX", "value346546");
        my.put("xwxwxwxwxwxwyXyXxwz9z9", "4564value");
        my.put("xwxwxwxwxwxwyXyXyXxwxw", "4564value");
        my.put("xwxwxwxwxwxwyXyXyXxwyX", "654value");
        my.put("xwxwxwxwxwxwyXyXyXxwz9", "356value");
        my.put("xwxwxwxwxwxwyXyXyXyXxw", "value");
        my.put("xwxwxwxwxwxwyXyXyXyXyX", "3563value");
        my.put("xwxwxwxwxwxwyXyXyXyXz9", "35463value");
        my.put("xwxwxwxwxwxwyXyXyXz9xw", "val45363ue");
        my.put("xwxwxwxwxwxwyXyXyXz9yX", "val356ue");
        my.put("xwxwxwxwxwxwyXyXyXz9z9", "valu25e");
        my.put("xwxwxwxwxwxwyXyXz9xwxw", "value25426");
        my.put("xwxwxwxwxwxwyXyXz9xwyX", "va23452lue");
        my.put("xwxwxwxwxwxwyXyXz9xwz9", "val243523ue");
        my.put("xwxwxwxwxwxwyXyXz9yXxw", "valu254234234e");
        my.put("xwxwxwxwxwxwyXyXz9yXyX", "valu25e");
        my.put("xwxwxwxwxwxwyXyXz9yXz9", "val25423452436ue");
        my.put("xwxwxwxwxwxwyXyXz9z9xw", "2345623464value");
        my.put("xwxwxwxwxwxwyXyXz9z9yX", "23462562value");
        my.put("xwxwxwxwxwxwyXyXz9z9z9", "v2542345234alue");
        my.put("xwxwxwxwxwxwyXz9xwxwxw", "valu23452345234e");
        my.put("xwxwxwxwxwxwyXz9xwxwyX", "valu234523452e");
        my.put("xwxwxwxwxwxwyXz9xwxwz9", "2346546value");
        my.put("xwxwxwxwxwxwyXz9xwyXxw", "6234562345value");
        my.put("xwxwxwxwxwxwyXz9xwyXyX", "23452346value");
        my.put("xwxwxwxwxwxwyXz9xwyXz9", "234523462value");
        my.put("xwxwxwxwxwxwyXz9xwz9xw", "623452345value");
        my.put("xwxwxwxwxwxwyXz9xwz9yX", "23462345value");
        my.put("xwxwxwxwxwxwyXz9xwz9z9", "23452346v2alue");
        my.put("xwxwxwxwxwxwyXz9yXxwxw", "234652345value");
        my.put("xwxwxwxwxwxwyXz9yXxwyX", "2345236value");
        my.put("xwxwxwxwxwxwyXz9yXxwz9", "2345243value");
        my.put("xwxwxwxwxwxwyXz9yXyXxw", "val24352345ue");


        System.out.println(my.get("xwxwxwxwxwxwyXz9yXyXxw"));
        System.out.println(my.get("xwxwxwxwxwxwyXz9yXxwyX"));
        my.put("1", "dadfas");

        my.put("11", "dadfas");
        add();
        System.out.println(my.get("1"));

        Collection<String> slist = my.values();
        Set<String> stringSet = my.keySet();

        Iterator i = slist.iterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("打印key");
        Iterator<String> seti = stringSet.iterator();
        while (seti.hasNext()) {
            System.out.println(seti.next());
        }


    }

    public static void add() {
        int a = 1, b = 3;

        Integer s = a + b;
    }
}
