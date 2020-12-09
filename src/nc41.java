import java.util.HashMap;

public class nc41 {
    public int maxLength (int[] arr) {
        // write code here
        // 一般1s的时间可以处理10^8，我们注意到n10^5
        // O(N*N)是不行的,O(nlogn)

        // 我的想法是维护一个hashmap存储值和位置的对应关系
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] dp = new int[arr.length+1];
        int maxx = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                // 读出重复元素的位置
                int pos = map.get(arr[i]);
                // 更新map
                map.put(arr[i],i);
                // 更新dp
                dp[i+1] = i-pos;
            }else{
                // 更新map
                map.put(arr[i],i);
                dp[i+1] = dp[i] + 1;
            }
            maxx = Math.max(dp[i+1],maxx);
        }
        return maxx;
    }

    public static void main(String[] args) {
        nc41 n = new nc41();
        int[] a={2,2,3,4,2};
        n.maxLength(a);
    }
}
