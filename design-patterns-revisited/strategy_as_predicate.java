import java.util.*;
import java.util.function.Predicate;

public class strategy_as_predicate {

    public static int totalValues(List<Integer> values, Predicate<Integer> selector) {
        int total = 0;
        for(var e: values) {
            if(selector.test(e)) {
                total += e;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5);
        System.out.println(totalValues(numbers, e -> true));
        System.out.println(totalValues(numbers, e -> e % 2 == 0));
        System.out.println(totalValues(numbers, e -> e % 2 == 1));
    }
}