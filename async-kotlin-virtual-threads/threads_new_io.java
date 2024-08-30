import java.util.*;
import java.io.*;
import java.nio.file.*;

// Super LWT - managed by JVM, virtual threads
// history: seq code -> try to run in parallel but mainly broken
//         <Java8      : In the past, the structure of imperative style seq code was very different from the structure of imperative style parallel code.
//          Java8      : The structure of functional style seq code is the same as the structure of functional style parallel code   +-->  thanks to the Stream API
//         >Java8      : The structure of functional styhle synchronous code, is the same as the structure of functional style asynchronous code  +-->  thanks to CompletableFuture
//         >Java21/19  : The structure of imperative style synchronous code is the same as the structure of imperative style synchronous code  +-->  thanks to project Loom (virtual threads)

//  It makes sense when dealing with I/O, not so much for computation. So Java has also introduces this idea of 'continuations' from Kotlin ..

public class threads_new_io {
    
    public static void fetch(int index) {
        System.out.println("entering " + index + " " + Thread.currentThread());

        try {
            var length = Files.lines(Paths.get("threads_new_io.java")).count();
            System.out.println("result " + index + " " + Thread.currentThread());
        } catch (Exception ex) {
            System.out.println("catch " + index + " " + Thread.currentThread());
        } finally {
            System.out.println("finally " + index + " " + Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        int MAX = 10;

        for(int i=0; i< MAX; i++) {
            int index = i;

            // new Thread(() -> fetch(index)).start();        // OLD way - each thread will print the result/catch/\finally
            Thread.startVirtualThread(() -> fetch(index));    // NEW way
        }

        try{ 
            Thread.sleep(5000);
        } catch (Exception ex) {}
        System.out.println("DONE");

    }
}
