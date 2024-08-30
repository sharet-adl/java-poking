import java.util.*;

public class ex1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        //Collection<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));

        System.out.println(numbers);  // [1, 2, 3]

        numbers.remove(1);

        System.out.println(numbers);  // [1, 3]

        // Q: If we change List<Integer> above to Collection<Integer>, what will happen ?
    }

    // There are 2 candidates with 1 overloading in List impl; remove(Object obj) and then added remove(int i) - bad idea; auto-boxing integer to Object
    // In Groovy there is a convept named multi-methods - so this problem would not occur
    //    The decision of which method to call, is done at runtime but the signature of the method at compile time .. 
    
}
