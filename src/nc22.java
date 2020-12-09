public class nc22 {
    public class Solution {
        public void merge(int A[], int m, int B[], int n) {
            // 题目的意思是不能再开辟额外的空间
            // 我们可以从A的m+n的位置开始向前填数字

            int i = m + n - 1;
            m--;
            n--;
            for (; i >= 0; i--) {
                if (m < 0 || n < 0) {
                    break;
                }
                if (A[m] > B[n]) {
                    A[i] = A[m];
                    m--;
                } else {
                    A[i] = B[n];
                    n--;
                }
            }
            while (m >= 0) {
                A[i--] = A[m--];
            }
            while (n >= 0) {
                A[i--] = B[n--];
            }
        }
    }
}
