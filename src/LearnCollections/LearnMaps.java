package LearnCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sandeep on 10/25/2016.
 */
public class LearnMaps {
    public static void main(String[] args) {
        Map<String, String> studentDir = new HashMap<String, String>();
        studentDir.put("1","Sandeep");
        studentDir.put("2","Gowthami");
        studentDir.put("3","Satish");
        Set<String> dirKeys = studentDir.keySet();
        for (String key:dirKeys) {
            System.out.println(key+" : "+studentDir.get(key));
        }

        Set<Map.Entry<String, String>> stuKeys = studentDir.entrySet();
        for (Map.Entry<String, String> stu:stuKeys) {
            System.out.println(stu.getKey()+" : "+stu.getValue());
        }


    }
}
