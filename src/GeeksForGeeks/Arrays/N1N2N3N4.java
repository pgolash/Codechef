package GeeksForGeeks.Arrays;

/**
 * Created by prashantgolash on 04/01/16.
 */
public class N1N2N3N4 {
//        var dp1 = new int[n1 + 1, n2 + 1, n3 + 1, n4 + 1];
//        var dp2 = new int[n1 + 1, n2 + 1, n3 + 1, n4 + 1];
//        var dp3 = new int[n1 + 1, n2 + 1, n3 + 1, n4 + 1];
//        var dp4 = new int[n1 + 1, n2 + 1, n3 + 1, n4 + 1];
//
//        const int MOD = 1000000007;
//        dp1[1, 0, 0, 0] = 1;
//        dp2[0, 1, 0, 0] = 1;
//        dp3[0, 0, 1, 0] = 1;
//        dp4[0, 0, 0, 1] = 1;
//
//        for (int i = 0; i <= n1; i++)
//        {
//            for (int j = 0; j <= n2; j++)
//            {
//                for (int k = 0; k <= n3; k++)
//                {
//                    for (int l = 0; l <= n4; l++)                                        {
//                        if (i + j + k + l > 1)
//                        {
//                            if (i > 0) dp1[i, j, k, l] = dp2[i - 1, j, k, l] + dp3[i - 1, j, k, l] + dp4[i - 1, j, k, l] % MOD;
//                            if (j > 0) dp2[i, j, k, l] = dp1[i, j - 1, k, l] + dp3[i, j - 1, k, l] + dp4[i, j - 1, k, l] % MOD;
//                            if (k > 0) dp3[i, j, k, l] = dp2[i, j, k - 1, l] + dp1[i, j, k - 1, l] + dp4[i, j, k - 1, l] % MOD;
//                            if (l > 0) dp4[i, j, k, l] = dp2[i, j, k, l - 1] + dp3[i, j, k, l - 1] + dp1[i, j, k, l - 1] % MOD;
//                        }
//                    }
//                }
//
//            }
//        }
//        return dp1[n1, n2, n3, n4] + dp2[n1, n2, n3, n4] + dp3[n1, n2, n3, n4] + dp4[n1, n2, n3, n4] % MOD;
//    }
}
