class 14{
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder(strs[0]);
        for (String s : strs) {
            StringBuilder temp = new StringBuilder(ans);
            ans.setLength(0);
            for (int i = 0; i < s.length() && i < temp.length(); i++) {
                if (temp.charAt(i) == s.charAt(i))
                    ans.append(s.charAt(i));
                else
                    break;
            }
        }
        return ans.toString();
    }
}
