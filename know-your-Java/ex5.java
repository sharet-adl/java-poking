import java.util.*;

// Functional programming relies on lazy evaluation, for efficiency.
//   Lazy evaluation relies on purity of functions (immutability) for correctness.

// In Kotlin, by default the pipeline is Eager evaluation. If you use asSequence(), then it will be lazy evaluation.
// In Java it is always LAZY evaluation.
// In JavaScript, is it alwasy eager evaluation.

public class ex5 {
    public static void main(String[] args) {
        int[] factor = new int[] { 2 };

        var numbers = List.of(1, 2, 3);

        var stream = numbers.stream()
            .map( number -> number * factor[0]);   // this line will be evaluated but not executed only until the Print below.
        
        factor[0] = 0;

        stream.forEach(System.out::print);
    }
    
}

// What is the output of this code ?
// - 000
// - 123
// - no clue