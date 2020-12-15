public class nc1 {
    public String solve(String s, String t) {
        // write code here
        int lens = s.length(), lent = t.length();
        String result = "";
        if (lens < lent) {
            String tmp = s;
            s = t;
            t = tmp;
            int tmp2 = lens;
            lens = lent;
            lent = tmp2;
        }
        // s的长度>t的长度
        s = "0" + s;
        lens++;
        s = new StringBuilder(s).reverse().toString();
        t = new StringBuilder(t).reverse().toString();
        // 补全，让lens和lent一样长
        for (int i = lent; i < lens; i++) {
            t = new StringBuilder(t).append('0').toString();
            lent++;
        }

        // 相加
        int add = 0;
        for (int i = 0; i < lens; i++) {
            int ans1 = Integer.valueOf(s.charAt(i)) - '0';
            int ans2 = Integer.valueOf(t.charAt(i)) - '0';
            int ans = ans1 + ans2;
            if (add > 0) {
                ans += add;
                add = 0;
            }
            if (ans >= 10) {
                ans -= 10;
                add = 1;
            }
            result = result + String.valueOf(ans);
        }
        // 去除末尾的0
        if (result == "0") return "0";
        result = new StringBuilder(result).reverse().toString();
        int cur = 0;
        for (int i = 0; i < lens; i++) {
            if (result.charAt(i) != '0') {
                cur = i;
                break;
            }
        }
        return result.substring(cur, lens);
    }

    public static void main(String[] args) {
        nc1 n = new nc1();
        System.out.println(n.solve("1", "99"));
    }
}
