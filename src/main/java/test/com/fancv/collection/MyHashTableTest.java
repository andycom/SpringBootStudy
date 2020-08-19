package test.com.fancv.collection;

import java.util.Hashtable;

/**
 * MyHashTable Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>8�� 11, 2020</pre>
 */
public class MyHashTableTest {

    public static void main(String[] args) {

        Hashtable mytable = new Hashtable();

        mytable.put(null, "1");

        System.out.println(mytable.get("1"));
    }

} 
