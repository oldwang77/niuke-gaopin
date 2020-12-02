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
        int length = 0;
        int index = 0;
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 2) {
                length++;
            }
        }
        int[] result = new int[length];
        Map<Integer, Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                int key = operators[i][1];
                int value = operators[i][2];
                if (map.size() < k) {
                    map.put(key, value);
                    if (list.contains(key)) {
                        list.remove((Integer) key);
                    }
                    list.add(key);

                } else {
                    if (list.contains(key)) {
                        list.remove((Integer) key);
                        list.add(key);
                    } else {
                        int get_key = list.remove(0);
                        map.remove(get_key);
                        list.add(key);
                        map.put(key, value);
                    }
                }
            } else if (operators[i][0] == 2) {
                int check_key = operators[i][1];
                if (!map.containsKey(check_key)) {
                    result[index] = -1;
                } else {
                    result[index] = map.get(check_key);
                    list.remove((Integer) check_key);
                    list.add(check_key);
                }
                index++;
            }
        }
        return result;
    }
}