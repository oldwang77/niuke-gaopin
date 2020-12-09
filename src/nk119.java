import java.util.ArrayList;

public class nk119 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length) {
            return result;
        }
        // 快速排序
        quickSort(input, 0, input.length-1);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public void quickSort(int[] a, int left, int right) {
        int i = left, j = right;
        if (left > right) {
            return;
        }
        int pivot = a[left];

        while (i < j) {
            while (i < j && a[j] >= pivot) {
                j--;
            }
            while (i < j && a[i] <= pivot) {
                i++;
            }
            if (i < j) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        // 交换哨兵
        a[left] = a[i];
        a[i] = pivot;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    public static void main(String[] args) {
        nk119 nk = new nk119();
        int[] a = {4, 5, 1, 6, 2, 7};
        int k = 4;
        nk.GetLeastNumbers_Solution(a, k);
    }
}
