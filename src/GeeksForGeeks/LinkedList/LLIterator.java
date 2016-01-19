package GeeksForGeeks.LinkedList;

/**
 * Created by prashantgolash on 04/01/16.
 */
public class LLIterator {
//    class MyIterator implements Iterator<Integer> {
//
//        Node n1; //traverses main nodes
//        Node n2; //traverses nested nodes
//
//        boolean traverseNestedNodes;
//
//        MyIterator(List list) {
//            n1 = list.start;
//            n2 = null;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return n2 != null || n1 != null;
//        }
//
//        @Override
//        public Integer next() {
//            int value;
//            if (n1 == null && n2 == null) {
//                throw new NoSuchElementException();
//            }
//
//            if (n2 == null) {
//                value = n1.value;
//                n2 = n1.nestedNodes;
//                n1 = n1.next;
//            } else {
//                value = n2.value;
//                n2 = n2.next;
//            }
//
//            return value;
//
//        }
//
//        @Override
//        public void remove() {
//
//        }
//    }
}
