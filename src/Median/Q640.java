package Median;

public class Q640 {
    public String solveEquation(String equation) {
        String[] splits = equation.split("=");
        int[] left = simplify(splits[0]);
        int[] right = simplify(splits[1]);
        int num = left[0] - right[0];
        int xValue = left[1] - right[1];
        if(num == 0 && xValue == 0) {
            return "Infinite solutions";
        }
        if(num != 0 && xValue == 0){
            return "No solution";
        }
        int ret = - num / xValue;
        StringBuilder sb = new StringBuilder();
        sb.append("x=");
        sb.append(ret);
        return String.valueOf(sb.toString());
    }
    public int[] simplify(String equation){
        equation = equation + "+";
        int num = 0;
        int xValue = 0;
        int temp = 0;
        boolean negative = false;
        for(int i = 0; i < equation.length(); i++){
            char c = equation.charAt(i);
            if(Character.isDigit(c)){
                temp = temp * 10 + c - '0';
            }
            else{
                if(equation.charAt(i) == 'x'){
                    if(temp == 0){
                        temp += 1;
                    }
                    if((i - 1 >= 0 && equation.charAt(i-1) == '0')){
                        temp = 0;
                    }
                    if(negative){
                        xValue -= temp;
                    }
                    else{
                        xValue += temp;
                    }
                }
                else{
                    if(negative){
                        num -= temp;
                    }
                    else{
                        num += temp;
                    }
                    if(equation.charAt(i) == '-'){
                        negative = true;
                    }
                    else{
                        negative = false;
                    }
                }
                temp = 0;
            }
        }
        return new int[]{num, xValue};
    }

    public static void main(String[] args) {
        Q640 q = new Q640();
        System.out.println(q.solveEquation( "0x=0"));
    }
}
