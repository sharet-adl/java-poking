import java.util.*;

// Immutability
// Arrays.asList(1,2,3) - partially immutable, allowing only updating elements
//  List.of(1,2,3) - immutable ( no set/not add )

// Preferable: List.of(), Map.of(), etc - due to the fact that it is immutable.
//  Copying is smart: if ref is also immutable, it will only handle a pointer; if not, it will copy (safely)

// What is the output of the code? 

public class ex3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        System.out.println(numbers); // [1, 2, 3]

        try {
            numbers.add(4);
            System.out.println("added");
        } catch(Exception ex) {
            System.out.println("Unsupported");
        }

        try {
            numbers.set(2, 2);
            System.out.println("set");
        } catch(Exception ex) {
            System.out.println("Unsupported");
        }

        System.out.println(numbers);
    }
    
}
