package Activities_java;
import java.util.HashMap;
public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
        hash_map.put(1, "Red");
        hash_map.put(2, "Green");
        hash_map.put(3, "Blue");
        hash_map.put(4, "White");
        hash_map.put(5, "Black");


        System.out.println("The Original map: " + hash_map);


        hash_map.remove(1);

        System.out.println("After removing Red: " + hash_map);


        if(hash_map.containsValue("Orange")) {
            System.out.println("Orange exists in the Map");
        } else {
            System.out.println("Orange does not exist in the Map");
        }


        System.out.println("Number of pairs in the Map is: " + hash_map.size());
    }
}
