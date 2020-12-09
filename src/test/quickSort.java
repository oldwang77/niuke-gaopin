package test;

public class quickSort {
    public void quicksort(int[] arr, int begin, int end) {
        int l = begin, r = end;
        if (begin > end) {
            return;
        }
        // 先确定哨兵
        int pivot = arr[begin];
        while (l < r) {
            // 先从右边向左边扫
            // 这里必须是大于等于，少了等于会报错！！
            while (r > l && arr[r] >= pivot) {
                r--;
            }
            while (r > l && arr[l] <= pivot) {
                l++;
            }
            // 进行swap交换
            if (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }
        // 哨兵的位置进行更改
        arr[begin] = arr[l];
        arr[l] = pivot;
        quicksort(arr, begin, l - 1);
        quicksort(arr, l + 1, end);
    }

    public static void main(String[] args) {
        quickSort q = new quickSort();
        int[] a = {5, 3, 1, 2, 4, 6};
        q.quicksort(a, 0, a.length - 1);
    }
}
