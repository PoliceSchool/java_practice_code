package com.java_practice_code.jvm;

/**
 * finalize()是Object的protected方法，子类可以覆盖该方法以实现资源清理工作，GC在回收对象之前调用该方法。
 * 当对象变成(GC Roots)不可达时，GC会判断该对象是否覆盖了finalize方法，若未覆盖，则直接将其回收。
 * 否则，若对象未执行过finalize方法，将其放入F-Queue队列，由一低优先级线程执行该队列中对象的finalize方法。
 * 执行finalize方法完毕后，GC会再次判断该对象是否可达，若不可达，则进行回收，否则，对象“复活”。
 *
 * 该方法的主要作用是在被GC回收前实现资源清理工作（比如IO操作被回收之前会先终止连接，比如FileInputStream），不建议复活对象
 * GC参考资料：
 * https://www.jianshu.com/p/ddc2556d0048
 * https://blog.csdn.net/mazhimazh/article/details/19752475
 *
 * idea打印GClog日志方法
 * -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * https://blog.csdn.net/bear_lam/article/details/79648701
 */
public class FinalizeTest {
    static class Book {

        private boolean checkIn;
        private String name;

        public Book(String name) {
            this.checkIn = true;
            this.name = name;
        }

        public void checkOut() {
            this.checkIn = false;
        }

        @Override
        protected void finalize() throws Throwable {
            if (this.checkIn) {
                System.out.println(this.name + " not check out yet");
            }
            super.finalize();
        }

        public static void main(String[] args) throws InterruptedException {
            Book book1 = new Book("天龙八部");

            new Book("哆啦a梦");

            System.gc();

            Thread.sleep(2000);
        }
    }
}
