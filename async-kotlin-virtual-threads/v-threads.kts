import kotlinx.coroutines.*

// Illustrate non-blocking


// nonblocking = suspend KEYWORD
// Using yield() to leave/re-enter --> not using ThreadLocal..  But 'continuations' concept, useful to build conversational state.
//   


suspend fun task1() {
    val value = 7
    println("Entering task1 ${Thread.currentThread()}")
    yield()  // left
             // re-enter later
    println("Exiting task1 ${Thread.currentThread()}")
    println(value)
}

suspend fun task2() {
    println("Entering task2 ${Thread.currentThread()}")
    yield()
    println("Exiting task2 ${Thread.currentThread()}")
}

//run {
// task1()
// task2()
//}

runBlocking {
    launch { task1() }  // non-blocking
    launch { task2() }  // non-blocking
    println("called the two tasks ${Thread.currentThread()}")
}

RC: ilvpbg2920
  Prateek Dhagat:
  Some CVD service that had to be killed .. Had to reboot the server as well.