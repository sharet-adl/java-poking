import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;

class ResourceBad {
    public ResourceBad() {System.out.println("created ..");}
    public ResourceBad op1() {System.out.println("op1"); return this;}
    public ResourceBad op2() {System.out.println("op2"); return this;}

    public void finalize() {System.out.println("clean up");}  //finalize will not be forced-called automtically, only when GC wants..
}

// A.R.M. = Automatic Resource Management in Java - to implement AutoCloseable
class Resource implements AutoCloseable {
    public Resource() {System.out.println("created ..");}
    public Resource op1() {System.out.println("op1"); return this;}
    public Resource op2() {System.out.println("op2"); return this;}
    public void close() {System.out.println("clean up");}
}

// Execute-around-method pattern
class BetterResource {
    
    private BetterResource() {System.out.println("created ..");}
    public BetterResource op1() {System.out.println("op1"); return this;}
    public BetterResource op2() {System.out.println("op2"); return this;}
    private void close() {System.out.println("clean up");}

    public static void use(Consumer<BetterResource> block) {
        BetterResource resource = new BetterResource();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }
}

public class execute_around_method {

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
        ResourceBad resourceB = new ResourceBad();
        resourceB.op1();
        resourceB.op2();

        // try-with-resource - must be wrapped with try{} so it will call the close()
        try(Resource resource = new Resource()) {
            resource.op1(); 
            resource.op2();
        }

        // execute-around-method
        BetterResource.use(resource ->
            resource.op1()
                .op2());
    }
}