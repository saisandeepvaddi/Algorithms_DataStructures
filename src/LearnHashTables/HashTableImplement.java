package LearnHashTables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * About the code :
 */
public class HashTableImplement {
    public static void main(String[] args) {
        Person sandeep = new Person("Sai Sandeep Vaddi", "7815 McCallum Blvd");
        Person gowthami = new Person("Gowthami Karamthota", "IIT Kharagpur");
        HashMap<String,Person> hashMap = new HashMap<>();
        hashMap.put("san",sandeep);
        hashMap.put("gow",gowthami);

        Set set =  hashMap.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            Map.Entry me = (Map.Entry) it.next();
            Person res = (Person) me.getValue();
            System.out.println(me.getKey().toString()+" "+res.getFullName()+" "+res.getAddress());
        }

        Set keySet = hashMap.keySet();
        for(Object key : keySet) if (key.toString() == "san"){
            System.out.println(key+" "+hashMap.get(key).getFullName()+" "+hashMap.get(key).getAddress());
        }

    }
}
