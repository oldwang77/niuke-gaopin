import java.util.*;

//方法二
public class nc93 {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */

    public int[] LRU(int[][] operators, int k) {
        // write code here
        int length = 0, index = 0;
        LinkedList<Integer> keyList = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 2) {
                length++;
            }
        }
        int[] result = new int[length];
        for (int i = 0; i < operators.length; i++) {
            int opt = operators[i][0];
            int key = operators[i][1];
            // put(key,value)
            if (opt == 1) {
                int value = operators[i][2];
                if (map.size() < k) {
                    map.put(key, value);
                    if (keyList.contains(key)) {
                        keyList.remove(key);
                    }
                    keyList.addLast(key);
                } else {
                    // 此时map已经满了
                    // 如果此时map里面已经有了这个key，那么不需要put进map中了
                    if (map.containsKey(key)) {
                        keyList.remove(key);
                        keyList.addLast(key);
                    } else {
                        Integer font = keyList.removeFirst();
                        map.remove(font);
                        map.put(key, value);
                        keyList.addLast(key);
                    }
                }
            }
            // get(key)
            else {
                if (map.containsKey(key) == false) {
                    result[index] = -1;
                } else {
                    // 确定Map里面有这个key了，那么此时keyList一定有这个key
                    // 此时不需要移除第一个元素，而是找到这个key的位置，给他置于末尾
                    result[index] = map.get(key);
                    keyList.remove((Integer) key);
                    keyList.addLast((Integer) key);
                }
                index++;
            }
        }
        return result;
    }
}