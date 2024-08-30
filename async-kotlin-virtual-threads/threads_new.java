import java.util.*;
import java.io.*;
import java.nio.file.*;

public class threads_new {
    public static void doWork() {
        try{ 
            Thread.sleep(2000);
        } catch (Exception ex) {}
    }
    
    public static void main(String[] args) {
        //int MAX = 1_000_000;
        int MAX = 10;

        for(int i=0; i< MAX; i++) {
            //new Thread(() -> doWork()).start();
            Thread.startVirtualThread(() -> doWork());
        }

        for(int i=0; i< MAX; i++) {
            int index = i;
            new Thread(() -> fetch(index)).start();
        }

        try{ 
            Thread.sleep(5000);
        } catch (Exception ex) {}
        System.out.println("DONE");

    }

    public static void fetch(int index) {
        System.out.println("entering " + index + " " + Thread.currentThread());

        try {
            var length = Files.lines(Paths.get("threads_new.java")).count();
            System.out.println("result " + index + " " + Thread.currentThread());
        } catch (Exception ex) {
            System.out.println("catch " + index + " " + Thread.currentThread());
        } finally {
            System.out.println("finally " + index + " " + Thread.currentThread());
        }
    }
}
