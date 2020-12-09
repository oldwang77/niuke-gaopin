public class nk88 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        // 寻找第k大的数
        // 快速排序的思路
        // findtop k
        return quickSort(a, 0, n-1, n, K);
    }

    public int quickSort(int[] a, int left, int right, int n, int k) {
        int i = left, j = right;
        if (left > right) {
            return 0;
        }
        int pivot = a[left];
        int res = 0;

        while (i < j) {
            // 这里的顺序改过了！a[j]>=pivot，因为这个是第K大，从大到小排序的
            while (i < j && a[j] <= pivot) {
                j--;
            }
            while (i < j && a[i] >= pivot) {
                i++;
            }
            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        a[left] = a[i];
        a[i] = pivot;
        // i左边都是比它小的数，i右边都是比他大的数
        // [0,i-1]一共有i个数,那么i此时就是第i+1大的数
        if (i + 1 == k) {
            return a[i];
        } else if (i + 1 > k) {
            // 证明第k大的数在i的左边
            res = quickSort(a, left, i - 1, n, k);
        } else {
            // 证明第k大的数在i的右边
            res = quickSort(a, i + 1, right, n, k);
        }
        return res;
    }
}
