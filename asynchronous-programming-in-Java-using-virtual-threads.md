https://www.youtube.com/watch?v=uoTyIFvckXA

Threadind:
- parallel vs concurrent
- parallel vs asynchrounous

Threads:
- threads are lightweight
-   but, 'lightweight' is relative
- how many threads can/should you create ?
-   depends on the amount of memory and number of cores


Continuations:
- sub-routines
- co-routines
- data-structure that can remember the state of a previous call and can continue from where it left off
- useful to build conversational state

Virtual-Threads in Java
- super lightweight threads
- managed by the JVM and not by the OS
- when a virtual threads blocks, the task waits but not the underlying thread
- revisiting the thread limitations
- using fibers/virtual threads



