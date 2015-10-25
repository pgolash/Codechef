package Design.Generics;

import java.util.ArrayList;
import java.util.List;
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
        //public void print();
    }

    class C implements B {
        public void print() {

        }
        public void print1() {

        }
    }

    public static void main(String[] args) {
    }

    public <T> void max(List<T> lt) {
        lt.set(0, lt.get(0));
    }





}
