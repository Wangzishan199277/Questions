import java.util.*;
import java.util.Random;
public class Pick{
    public static class PickRandom{
        List<Integer> value;
        Map<Integer, Integer> hash;
        Random rand;
        PickRandom() {
            value = new ArrayList<Integer>();
            hash = new HashMap<Integer, Integer>();
            rand = new Random();
        }
        void insert(int val) {
            if(!hash.containsKey(val)) {
                value.add(val);
                int position = value.size()-1;
                hash.put(val, position);
            }
        }
        
        boolean Contains(int val) {
            return hash.containsKey(val);
        }
        
        void Delete(int val) {
            if(!hash.containsKey(val)) {
                return;
            }
            int position_val = hash.get(val);
            int position_last = value.size()-1;
            hash.put(value.get(position_last), position_val);
            int temp = value.get(position_val);
            value.set(position_val, value.get(position_last));
            value.set(position_last, temp);
            value.remove(position_last);
            hash.remove(val);
        }
        
        int pickRandom() {
            if(value.size() == 0) {
                return -1;
            }
            int pos = rand.nextInt(value.size());
            return value.get(pos);
        }
    }
     public static void main(String []args){
        PickRandom pick = new PickRandom();
        for(int i = 1; i <= 10; i++) {
            pick.insert(i);
        }
        System.out.println("Test of Constains");
        System.out.println(pick.Contains(11));
        for(int i = 1; i <= 10; i++) {
            System.out.print(pick.Contains(i) + " ");
        }
        System.out.println("");
        System.out.println("");
        
        System.out.println("Output the value");
        for(int i = 0; i < pick.value.size(); i++) {
            System.out.print(pick.value.get(i) + " ");
        }
        System.out.println("");
        System.out.println("");
        
        pick.Delete(3);
        System.out.println("value after delete of 3");
        for(int i = 0; i < pick.value.size(); i++) {
            System.out.print(pick.value.get(i) + " ");
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("hash value of 10 is " + pick.hash.get(10));
        System.out.println("");
        System.out.println("value of 100 pickRandom");
        for(int i = 0; i < 100; i++) {
            System.out.print(pick.pickRandom() + " ");
        }
     }
}
