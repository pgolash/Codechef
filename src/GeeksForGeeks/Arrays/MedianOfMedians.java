package GeeksForGeeks.Arrays;

/**
 * Created by prashantgolash on 12/01/16.
 */
public class MedianOfMedians {
//    select(L,k)
//    {
//        if (L has 10 or fewer elements)
//        {
//            sort L
//            return the element in the kth position
//        }
//
//        partition L into subsets S[i] of five elements each
//        (there will be n/5 subsets total).
//
//        for (i = 1 to n/5)
//        do
//          x[i] = select(S[i],3)
//
//        M = select({x[i]}, n/10)
//
//        partition L into L1<M, L2=M, L3>M
//        if (k <= length(L1))
//            return select(L1,k)
//        else if (k > length(L1)+length(L2))
//            return select(L3,k-length(L1)-length(L2))
//        else return M
//    }

////  Find kth largest( int k, int beg, int end )
//
//    {
//        i = Magic(); // 'i' is the index of the median element
//        /*
//           Here in a single pass, shift all the elements smaller than A[i] to the left and
//           greater than A[i] to the right. So A[i] occupies its correct place in the list.
//         */
//        if ( i == k )
//            Return the element a[i];
//        else if ( i < k )
//        Return Find_kth_largest ( k, i+1 , end);
//        else
//        Return Find_kth_largest ( k-(n-i), beg, i );
//
//    }

}
