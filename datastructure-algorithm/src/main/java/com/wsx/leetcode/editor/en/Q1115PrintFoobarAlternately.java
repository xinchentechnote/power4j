package com.wsx.leetcode.editor.en;

//Suppose you are given the following code: 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// The same instance of FooBar will be passed to two different threads. Thread A
// will call foo() while thread B will call bar(). Modify the given program to out
//put "foobar" n times. 
//
// 
//
// Example 1: 
//
// 
//Input: n = 1
//Output: "foobar"
//Explanation: There are two threads being fired asynchronously. One of them cal
//ls foo(), while the other calls bar(). "foobar" is being output 1 time.
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: "foobarfoobar"
//Explanation: "foobar" is being output 2 times.
// 
// 👍 253 👎 22


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//Java：Print FooBar Alternately
public class Q1115PrintFoobarAlternately{
    public static void main(String[] args) {
        FooBar solution = new FooBar(10);
        // TO TEST
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
class FooBar {

    private int n;


    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private volatile boolean printFooFlag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (!printFooFlag) {
                    fooCondition.await();
                }
                printFoo.run();
                printFooFlag = false;
                barCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (printFooFlag) {
                    barCondition.await();
                }
                printBar.run();
                printFooFlag = true;
                fooCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}