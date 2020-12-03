public class nc105 {
    // 有序数组的二分查找
    // 找到数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        // write code here
        int len = a.length;
        int left = 0, right = len - 1;
        int mid = 0;
        // 此时无解，大于数组中的最大的数
        if(v>a[n-1]) return n+1;
        while (left < right) {
            mid = left + (right - left) / 2;
            // 相等的时候，让右边等于mid，画图看看为什么是right = mid，而不是让left等于！
            // right始终确保右边界不过线
            if (a[mid] >= v) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left+1;
    }
}
