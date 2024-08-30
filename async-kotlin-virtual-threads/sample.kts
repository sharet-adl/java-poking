// $ kotlinc-jvm sample.kts
// $ ls META-INF/ Sample.class sample.kts
// javap Sample.class  // check the bytecode
//     The 'operate' is not a subroutine, but a coroutine, Compiler will inject a Continuation<> in the list of parameters ..

fun compute(n: Int) = n * 2

suspend fun operate(n: Int) = n * 2