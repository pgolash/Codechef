    package Library;

    import java.io.Serializable;
    import java.util.*;


    abstract class Fruit implements Comparable<Fruit> {
        protected String name;
        protected int size;
        protected Fruit(String name, int size) {
            this.name = name; this.size = size;
        }

        public boolean equals(Object o) {
            if (o instanceof Fruit) {
                Fruit that = (Fruit)o;return this.name.equals(that.name) && this.size == that.size;
            } else return false;
        }

        public int hashCode() {
            return name.hashCode()*29 + size;
        }

        public int compareTo(Fruit that) {
            return this.size < that.size ? - 1 :
                    this.size == that.size ? 0 : 1 ;
        }
    }

    class Apple extends Fruit {
        public Apple(int size) { super("Apple", size); }
        public int compareTo(Apple a) { return super.compareTo(a); }
    }
    class Orange extends Fruit {
        public Orange(int size) { super("Orange", size); }
        public int compareTo(Orange o) { return super.compareTo(o); }
    }

    public class BinaryIndexedTree implements Serializable {

        public static <T extends Comparable<? super T>> T max (Collection<? extends  T> coll) {
            T candidate = coll.iterator().next();

            for (T elt : coll) {
                if (candidate.compareTo(elt) < 0) {
                    candidate = elt;
                }
            }

            return candidate;
        }

        public static void main(String[] args) {
            List<?> myL = new ArrayList<Object>();

            Apple a1 = new Apple(1);
            Apple a2 = new Apple(2);
            Orange o3 = new Orange(3);
            Orange o4 = new Orange(4);
            List<Apple> apples = Arrays.asList(a1, a2);
            assert Collections.max(apples).equals(a2);

            List<Orange> oranges = Arrays.asList(o3, o4);
            assert Collections.max(oranges).equals(o4);

            List<Fruit> mixed = Arrays.<Fruit>asList(a1, o3);
            assert Collections.max(mixed).equals(o3);
        }
    }