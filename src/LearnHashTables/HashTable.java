package LearnHashTables;

import java.util.LinkedList;

/**
 * About the code :
 */
public class HashTable {
    private LinkedList<Person>[] list = null;

    public HashTable(int length){
        list = new LinkedList[length];
        Person dummy = new Person("","");
        for (int i = 0; i < length; i++) {
            list[i].add(0,dummy);
        }
    }

    public void put(String key, Person value){
        int hashCode = getHashCode(key);
        int index = getIndex(hashCode, list.length);
        list[index].add(value);
    }
  

    public Person get(String key){
        int hashCode = getHashCode(key);
        int index = getIndex(hashCode, list.length);
        return list[index].getFirst();
    }

    private int getIndex(int hashCode, int length) {
        return hashCode%length;
    }

    private int getHashCode(String key) {
        int a = 0;
        for (int i = 0; i < key.length(); i++) {
            a += (int) key.charAt(i);
        }
        return Integer.hashCode(a);
    }

}
