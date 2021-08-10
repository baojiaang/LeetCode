package Easy;

public class Q171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for(int i = 0; i < columnTitle.length(); i++){
            char c = columnTitle.charAt(columnTitle.length() - i - 1);
            int base = (int) Math.pow(26,i);
            res += (c - 'A' + 1) * base;
        }
        return res;
    }
}
