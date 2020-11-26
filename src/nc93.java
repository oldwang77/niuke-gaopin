import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class nc93 {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    LinkedList<Integer> ans = new LinkedList<>();
    List<Integer> result = new ArrayList<>();

    public int[] LRU(int[][] operators, int k) {
        // write code here
        for (int[] oper : operators) {
            int opt = oper[0];
            int x = oper[1], y = 0;
            if (oper.length == 3) {
                y = oper[2];
            }
            if (opt == 1) {
                setResult(x, y, k);
            } else {
                getResult(x, k);
            }
        }
        int[] ans = new int[result.size()];
        int cnt = 0;
        for(int i=0;i<result.size();i++){
            ans[i] = result.get(i);
        }
        return ans;
    }


    public void setResult(int x, int y, int k) {
        // 将X设置为Y

        // 此时需要移除一个元素
        if (hashMap.size() >= k && !hashMap.containsKey(x)) {
            // 找到此时优先级最低的元素
            Integer low = ans.removeLast();
            hashMap.remove(low);
        }

        // 调整元素的优先级
        if (!hashMap.containsKey(x)) {
            ans.addFirst(x);
        } else {
            ans.remove(x);
            ans.addFirst(x);
        }
        hashMap.put(x, y);
    }

    public void getResult(int x, int k) {
        // 获取x的值

        if (!ans.contains(x)) {
            result.add(-1);
        }else{
            ans.remove(x);
            result.add(hashMap.get(x));
            // 提升这个优先级
            ans.addFirst(x);
        }
    }
}
