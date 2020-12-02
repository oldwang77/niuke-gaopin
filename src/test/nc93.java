package test;

import java.util.*;

public class nc93 {
    public int[] LRU(int[][] operators, int k) {
        int length =0,index=0;
        LinkedList<Integer> keyList = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<operators.length;i++){
            if(operators[i][0]==2){
                length++;
            }
        }
        int[] result = new int[length];

        for(int i=0;i<operators.length;i++){
            int opt = operators[i][0];
            int key = operators[i][1];

            // opt==1，表示put(key,value)
            if(opt==1) {
                int value = operators[i][2];
                if(map.size()<k){
                    map.put(key,value);
                    if(keyList.contains(key)){
                        keyList.remove((Integer)key);
                    }
                    keyList.addLast(key);
                }
                // 集合装满了，需要去除此时的第一个元素
                else{
                    if(keyList.contains((Integer)key)){
                        keyList.remove((Integer)key);
                        keyList.addLast(key);
                    }else{
                        int get_key = keyList.removeFirst();
                        map.remove((Integer)get_key);
                        keyList.addLast(key);
                        map.put(key,value);
                    }
                }
            }
            // 此时是get(key)
            else if(opt==2){
                if(map.containsKey(key)==false){
                    result[index]=-1;
                }else{
                    result[index] = map.get(key);
                    keyList.remove((Integer)key);
                    keyList.addLast(key);
                }
                index++;
            }
        }
        return result;
    }
}