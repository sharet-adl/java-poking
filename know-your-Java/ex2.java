import java.util.*;

// Using var - type inference.
// By default it will bind to closest type/concrete type you defined, and not to interface
//
// Haskel - very 

public class ex2 {
    public static void main(String[] args) {
        Collection<Integer> numbers = new ArrayList<Integer>(List.of(1, 2, 3));
        //var numbers = new ArrayList<Integer>(List.of(1, 2, 3));

        System.out.println(numbers); // [1, 2, 3]

        numbers.remove(1);

        System.out.println(numbers); // [2, 3]

        // Q: If we change Collection<Integer> above to 'var', what will be the output ?
    }
    
}
