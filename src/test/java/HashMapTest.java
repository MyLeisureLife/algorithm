import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap();
        for (Integer i = 0; i < 100000; i++) {
            hashMap.put(i.toString(),i);
        }
        System.out.println(hashMap.toString());

    }
}
