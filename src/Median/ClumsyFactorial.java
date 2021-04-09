package Median;

import java.util.Stack;
/*
* 也可用栈， 遇到减号时存一个相反数进去
* */
public class ClumsyFactorial {
    public int clumsy(int N) {
        int res = 0;
        for(int i = N; i > 0 ;){
            if( i == N){
                int temp_res = 0;
                int a = -1;
                int b = -1;
                int c = -1;
                int d = -1;
                for(int count = 0; count < 4 && i > 0; i-- ,count++){
                    switch (count){
                        case 0:
                            a = i;
                            temp_res = a;
                            break;
                        case 1:
                            b = i;
                            temp_res = a * b;
                            break;
                        case 2:
                            c = i;
                            temp_res = a * b / c;
                            break;
                        case 3:
                            d = i;
                            temp_res = a * b / c + d;
                            break;
                    }
                }
                res += temp_res;
            }
            else{
                int temp_res = 0;
                int a = -1;
                int b = -1;
                int c = -1;
                int d = -1;
                for(int count = 0; count < 4 && i > 0; i-- , count++ ){
                    switch (count){
                        case 0:
                            a = i;
                            temp_res = - a;
                            break;
                        case 1:
                            b = i;
                            temp_res = - a * b;
                            break;
                        case 2:
                            c = i;
                            temp_res = - a * b / c;
                            break;
                        case 3:
                            d = i;
                            temp_res = - a * b / c + d;
                            break;
                    }
                }
                res += temp_res;
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        ClumsyFactorial c = new ClumsyFactorial();
        c.clumsy(4);
    }
}
