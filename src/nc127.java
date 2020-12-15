public class nc127 {
    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        // write code here
        int len1 = str1.length(), len2 = str2.length();
        String ans = "-1";
        int maxx = 0;
        int[][] res = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    res[i + 1][j + 1] = res[i][j] + 1;
                } else {
                    res[i + 1][j + 1] = 0;
                }
                if (res[i + 1][j + 1] > maxx) {
                    maxx = res[i + 1][j + 1];
                    ans = str1.substring(i + 1 - maxx, i + 1);
                }
            }
        }
        if (maxx == 0) {
            return "-1";
        }
        return ans;
    }
}
