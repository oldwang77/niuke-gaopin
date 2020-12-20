import java.util.*;

public class nc32 {
    public int sqrt(int x) {
        // write code here
        // 二分查找
        int left = 0, right = x;
        int mid = 0;
        if (x == 0 || x == 1) {
            return x;
        }
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mid * mid < x) {
                left = mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                return mid;
            }

            int ans1 = mid * mid;
            int ans2 = (mid + 1) * (mid + 1);
            int ans3 = (mid - 1) * (mid - 1);
            if (ans1 < x && ans2 > x) {
                return ans1;
            }
            if (ans3 < x && ans1 > x) {
                return ans3;
            }
        }

        return 0;
    }
}
