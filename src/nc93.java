import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

//方法二
public class nc93 {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */

    HashMap<Integer, Integer> map = new HashMap<>();//存map
    LinkedList<Integer> keyList = new LinkedList<Integer>();//存key队列

    public int[] LRU(int[][] operators, int k) {
        // write code here

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            int opt = operators[i][0], key = operators[i][1];
            if (keyList.contains(key)) keyList.remove(new Integer(key));
            keyList.addFirst(key);
            if (opt == 1) {//set
                int value = operators[i][2];
                if (map.size() == k) {//超过缓存限制
                    if (map.get(key) == null) {//map中没有key,必须移除最近最少使用key
                        int k1 = keyList.removeLast();
                        map.remove(k1, map.get(k1));
                        map.put(key, value);
                    } else {
                        map.put(key, value);
                    }
                } else {//没超过缓存限制
                    map.put(key, value);
                }
            } else if (opt == 2) {//get，不要忘记get后也要将key设为最新
                if (map.get(key) == null) {
                    list.add(-1);
                } else {
                    list.add(map.get(key));
                }
            }
            if (!map.containsKey(key)) keyList.removeFirst();//判断结束后map有没有把key,v加入map,没有就没有这个key,要移除
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        map.clear();
        keyList.clear();
        return res;
    }
}