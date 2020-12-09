//public class QuickSort {
//    public void quickSort(int[] arr, int left, int right) {
//        int i = left, j = right;
//        if (left > right) {
//            return;
//        }
//        //基准数
//        int pivot = arr[left];
//
//        while (i != j) {
//            while (i < j && arr[j] >= pivot) {
//                j--;
//            }
//            while (i < j && arr[i] <= pivot) {
//                i++;
//            }
//
//            if (i < j) {
//                int tmp = arr[j];
//                arr[j] = arr[i];
//                arr[i] = tmp;
//            }
//        }
//        // 调整基准位置数字
//        arr[left] = arr[i];
//        arr[i] = pivot;
//
//        quickSort(arr, left, i - 1);
//        quickSort(arr, i + 1, right);
//    }
//
//    public static void main(String[] args) {
//        QuickSort q = new QuickSort();
//        int[] arr = {4, 2, 3, 1, 7, 6};
//        q.quickSort(arr, 0, arr.length - 1);
//    }
//}
