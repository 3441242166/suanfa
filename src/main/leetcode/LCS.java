package main.leetcode;

public class LCS {

    public static void main(String[] args) {

        String s1 = "121314";
        String s2 = "214";

        showStr(getLong(s1, s2), s1, s2, s1.length(), s2.length());

    }


    public static int[][] getLong(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        //��ʼ��DP����
        for (int x = 0; x < dp.length; x++) {
            dp[x][0] = 0;
        }
        for (int x = 0; x < dp[0].length; x++) {
            dp[0][x] = 0;
        }

        for (int x = 1; x < dp.length; x++) {

            for (int y = 1; y < dp[0].length; y++) {

                if (str1[x - 1] == str2[y - 1]) {
                    dp[x][y] = dp[x - 1][y - 1] + 1;
                } else {
                    dp[x][y] = Math.max(dp[x][y - 1], dp[x - 1][y]);
                }

            }

        }


        return dp;
    }

    public static void showStr(int dp[][], String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            showStr(dp, s1, s2, i - 1, j - 1);
            System.out.print(s1.charAt(i - 1));
        } else if (dp[i - 1][j] >= dp[i][j]) {
            showStr(dp, s1, s2, i - 1, j);
        } else {
            showStr(dp, s1, s2, i, j - 1);
        }
    }
}

