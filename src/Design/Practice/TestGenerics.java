package Design.Practice;

import java.util.Objects;

/**
 * Created by prashantgolash on 8/9/15.
 */
public class TestGenerics {

    interface A {
        public void print();
    }

    interface B extends A {
        public void print1();
        public void print();
    }

    class C implements B {
        public void print() {

        }
        public void print1() {

        }
    }

    public static void main(String[] args) {

        Integer int1 = 12;
        Object o = int1;

        System.out.println(o.getClass());

    }
}
