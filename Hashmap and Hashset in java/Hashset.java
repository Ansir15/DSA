import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {
        // ✅ Create HashSet
        HashSet<String> fruits = new HashSet<>();

        // ✅ Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");  // Duplicate — will be ignored

        // ✅ Print HashSet
        System.out.println("Fruits: " + fruits);

        // ✅ Check if an element exists
        if (fruits.contains("Banana")) {
            System.out.println("Banana is in the set");
        }

        // ✅ Remove an element
        fruits.remove("Orange");

        // ✅ Size of set
        System.out.println("Set size: " + fruits.size());

        // ✅ Loop through HashSet
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // ✅ Clear all elements
        fruits.clear();
        System.out.println("After clearing: " + fruits);
    }
}
