import java.util.*;

// Super LWT - managed by JVM, virtual threads


public class threads_old {
    public static void doWork() {
        try{ 
            Thread.sleep(2000);
        } catch (Exception ex) {}
    }
    
    public static void main(String[] args) {
        //int MAX = 1;
        //int MAX = 100;
        int MAX = 10000;

        for(int i=0; i< MAX; i++) {
            new Thread(() -> doWork()).start();
        }

        try{ 
            Thread.sleep(5000);
        } catch (Exception ex) {}
        System.out.println("DONE");

    }
}
