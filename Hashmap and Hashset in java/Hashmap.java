import java.util.HashMap;

public class Hashmap {
    public static void main(String[] args) {
        // ✅ 1. Create a HashMap
        HashMap<String, Integer> studentMarks = new HashMap<>();

        // ✅ 2. Add entries using put()
        studentMarks.put("Ali", 85);
        studentMarks.put("Sara", 92);
        studentMarks.put("Usman", 75);

        // ✅ 3. Get a value
        System.out.println("Sara's marks: " + studentMarks.get("Sara"));

        // ✅ 4. Update value
        studentMarks.put("Ali", 90); // Overwrites 85

        // ✅ 5. Check if key exists
        if (studentMarks.containsKey("Usman")) {
            System.out.println("Usman's marks: " + studentMarks.get("Usman"));
        }

        // ✅ 6. Iterate over keys and values
        for (String name : studentMarks.keySet()) {
            System.out.println(name + ": " + studentMarks.get(name));
        }

        // ✅ 7. Remove a key
        studentMarks.remove("Usman");

        // ✅ 8. Size of map
        System.out.println("Total Students: " + studentMarks.size());

        // ✅ 9. Check if empty
        System.out.println("Map empty? " + studentMarks.isEmpty());

        // ✅ 10. Clear all entries
        studentMarks.clear();
        System.out.println("Map after clear: " + studentMarks);
    }
}
