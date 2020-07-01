package Median;

/*
* Solution: My solution is use two-dimensional array, this solution is very simple but it require O(n²) space complexity
* A good solution is use flag to judge when to turn the zig-zag direction
* Use a flag to add the row +1 or -1, which only take O(n) space
* */

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        char matrix[][]=new char[numRows][s.length()];
        char charArray[]=s.toCharArray();
        int col=0;
        for(int i=0;i<numRows;i++){
            for(int j=0;j<s.length();j++){
                matrix[i][j]=' ';
            }
        }
        if(numRows==1)
            return s;
        for(int i=0;i<charArray.length;){
            char c=charArray[i];
            int size=numRows-1;
            for(int j=0;j<size&&i<charArray.length;j++,col++){
                if(j==0){
                    for(int k=0;k<numRows&&i<charArray.length;k++){
                        matrix[k][col]=charArray[i];
                        i++;
                    }
                }
                else{
                    int putIndex=numRows-j-1;
                    for(int k=0;k<numRows&&i<charArray.length;k++){
                        if(k==putIndex){
                            matrix[k][col]=charArray[i];
                            i++;
                        }
                        else{

                        }
                    }
                }
            }
        }
//        for(int i=0;i<numRows;i++){
//            for(int j=0;j<s.length();j++){
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<s.length();j++){
                if(matrix[i][j]!=' ')
                    stringBuilder.append(matrix[i][j]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion=new ZigZagConversion();
        String s="A";
        zigZagConversion.convert(s,1);
    }
}
