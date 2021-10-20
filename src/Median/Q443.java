package Median;

public class Q443 {
    public int compress(char[] chars) {
        char pre = chars[0];
        int res = 0;
        int temp = 1;
        if (chars.length < 2)
            return 1;
        int idx = 0;
        for (int i = 1; i < chars.length; i++) {
            char cur = chars[i];
            if (pre == cur) {
                temp++;
            } else {
                int len = len(temp);
                res++;
                chars[idx++] = pre;
                if (temp > 1) {
                    res += len;
                    StringBuffer sb = new StringBuffer();
                    sb.append(temp);
                    for (int j = 0; j < len; j++, idx++) {
                        chars[idx] = sb.toString().charAt(j);
                    }
                }
                temp = 1;
            }
            pre = cur;
        }

        int len = len(temp);
        res++;
        chars[idx++] = pre;
        if (temp > 1) {
            res += len;
            StringBuffer sb = new StringBuffer();
            sb.append(temp);
            for (int j = 0; j < len; j++, idx++) {
                chars[idx] = sb.toString().charAt(j);
            }
        }

        return res;
    }

    public int len(int num) {
        int res = 1;
        while (num / 10 > 0) {
            res++;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        Q443 q = new Q443();
        System.out.println(q.compress(chars));

    }
}
