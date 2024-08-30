
// Scope: others to not extend from your classes, or implement your interfaces

// UNCOMMENT => The type BrokenLight that implements a sealed interface TrafficLight should be a permitted subtype of TrafficLightJava(16779069)
// final class BrokenLight implements TrafficLight{}

public class sealed_hierarchy {

    public static void main(String[] args) {
        TrafficLight tl = new RedLight();
        System.out.println(tl);
    }
}