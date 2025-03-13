    package Java_Concept;

    import java.util.Hashtable;
    import java.util.Iterator;
    import java.util.Map;
    import java.util.Set;

    public class Map_HashTable {
        public static void main(String[] args) {
            // The Hashtable class implements the Map interface and extends the Dictionary class.
            // Unlike HashMap, it does not allow null keys or null values.
            // It is synchronized, meaning it is thread-safe but slower compared to HashMap.

            Hashtable<Integer, String> hashtable = new Hashtable<>();
            hashtable.put(1, "Alice");
            hashtable.put(2, "Bob");
            hashtable.put(3, "Charlie");
            hashtable.put(4, "john");
            // hashtable.put(null, "Eve"); // This will throw a NullPointerException
            // hashtable.put(5, null); // This will also throw a NullPointerException

            System.out.println("-----------Using for-each loop----------------------");
            for (Map.Entry<Integer, String> entry : hashtable.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }

            System.out.println("---------------Replace-----------");
            hashtable.replace(2, "Bob", "Bobby");
            for (Map.Entry<Integer, String> entry : hashtable.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }

            System.out.println("---------------Remove-----------");
            hashtable.remove(3);
            for (Map.Entry<Integer, String> entry : hashtable.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }

            System.out.println("-------------Using iterator--------------------");
            Set<Map.Entry<Integer, String>> set = hashtable.entrySet();
            Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> entry = iterator.next();
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }

            System.out.println("-------------Using values() and keys()--------------------");
            System.out.println("Values:");
            for (String value : hashtable.values()) {
                System.out.println(value);
            }

            System.out.println("Keys:");
            for (Integer key : hashtable.keySet()) {
                System.out.println(key);
            }

            System.out.println("-------------Using entrySet with Iterator--------------------");
            Set<Map.Entry<Integer, String>> entrySet = hashtable.entrySet();
            Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, String> entry = it.next();
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }
    }
