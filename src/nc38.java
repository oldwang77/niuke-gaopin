import java.util.*;

public class nc38 {

    int m, n;
    ArrayList<Integer> list = new ArrayList<>();
    int[][] flag;

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        if (m == 0) {
            return list;
        }
        n = matrix[0].length;
        flag = new int[m][n];
        int x = 0, y = 0, cnt = 1;
        list.add(matrix[x][y]);
        flag[x][y] = 1;

        while (cnt < m * n) {
            // 向右移动
            while (check(x, y + 1)) {
                y++;
                list.add(matrix[x][y]);
                flag[x][y] = 1;
                cnt++;
            }
            // 向下移动
            while (check(x + 1, y)) {
                x++;
                list.add(matrix[x][y]);
                flag[x][y] = 1;
                cnt++;
            }
            // 向左移动
            while (check(x, y - 1)) {
                y--;
                list.add(matrix[x][y]);
                flag[x][y] = 1;
                cnt++;
            }
            // 向上移动
            while (check(x - 1, y)) {
                x--;
                list.add(matrix[x][y]);
                flag[x][y] = 1;
                cnt++;
            }
        }
        return list;
    }

    public boolean check(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return false;
        if (flag[x][y] == 1) return false;
        return true;
    }

    public static void main(String[] args) {
        nc38 n = new nc38();
        int[][]  matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(n.spiralOrder(matrix));
    }

}
