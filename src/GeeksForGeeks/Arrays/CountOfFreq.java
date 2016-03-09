package GeeksForGeeks.Arrays;

/**
 * Created by prashantgolash on 29/01/16.
 */
public class CountOfFreq {
//    Count frequencies of all elements in array in O(1) extra space and O(n) time
//    Given an unsorted array of n integers which can contain integers from 1 to n. Some elements can be repeated multiple times and some other elements can be absent from the array. Count frequency of all elements that are present and print the missing elements.
//
//            Examples:
//
//    Input: arr[] = {2, 3, 3, 2, 5}
//    Output: Below are frequencies of all elements
//    1 -> 0
//            2 -> 2
//            3 -> 2
//            4 -> 0
//            5 -> 1
//
//    Input: arr[] = {4, 4, 4, 4}
//    Output: Below are frequencies of all elements
//    1 -> 0
//            2 -> 0
//            3 -> 0
//            4 -> 4
//    A Simple Solution is to create a count array of size n as the elements are in range from 1 to n. This solution works in O(n) time, but requires O(n) extra space.
//
//    How to do it in O(1) extra space and O(n) time?
//
//    Below are two methods to solve this in O(n) time and O(1) extra space. Both method modify given array to achieve O(1) extra space.
//
//    Method 1 (By making elements negative)
//    The idea is to traverse the given array, use elements as index and store their counts at the index. For example, when we see element 7, we go to index 6 and store the count. There are few problems to handle, one is the counts can get mixed with the elements, this is handled by storing the counts as negative. Other problem is loosing the element which is replaced by count, this is handled by first storing the element to be replaced at current index.
//
//            Algorithm:
//            1) Initialize i as 0
//            2) Do following while i < n
//
//    // If this element is already processed,
//    // then nothing to do
//    a) If arr[i] <= 0
//    i++;
//    continue the loop from beginning
//
//    // Find index corresponding to this element
//    // For example, index for 5 is 4
//    b)  elementIndex = arr[i]-1;
//
//    // If the elementIndex has an element that is not
//    // processed yet, then first store that element
//    // to arr[i] so that we don't loose anything.
//    c) if (arr[elementIndex] > 0)
//            (i) arr[i] = arr[elementIndex];
//
//    // After storing arr[elementIndex], change it
//    // to store initial count of 'arr[i]'
//    (ii) arr[elementIndex] = -1;
//
//    d) else
//            // If this is NOT first occurrence of arr[i],
//            // then increment its count.
//            (i) arr[elementIndex]--;
//
//    // And initialize arr[i] as 0 means the element
//    // 'i+1' is not seen so far
//    (ii) arr[i] = 0;
//    (iii) i++;
//
//    3) Now -arr[i] stores count of i+1.

}
