import java.util.*;

// What is wrong with this code ?

// Try to change names.stream() --> names.stream().parallel() and rerun..
// Mutability and sharing is good .. Shared mutability is dangerous - 'inUppercase' !
// Functional programming was introduced in laguages where immutabilitiy was enforced ( Haskel - very higly opinionated, not like Java ).


public class ex4 {
    public static void main(String[] args) {

        for(int i=0; i<100; i++) {
            List<String> names = List.of("N1", "N2", "N3", "N4", "N5", "N6", "N7");

            List<String> inUppercase = new ArrayList<>();

            names.stream()
                .map(String::toUpperCase)
                .forEach(name -> inUppercase.add(name));
            
            System.out.println(names.size());
            System.out.println(inUppercase.size());
        }
    }
    
}
