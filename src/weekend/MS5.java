package weekend;
import java.sql.SQLOutput;
import java.util.*;
public class MS5 {
    public int solution(int[] X, int[] Y) {
        // write your code in Java SE 8
        HashMap<Fraction,Integer> map = new HashMap<>();
        for(int i = 0; i < X.length; i++){
            int numerator = X[i];
            int denominator = Y[i];
            Fraction f = new Fraction(numerator,denominator);
            System.out.println(f.hashCode());
            if(map.containsKey(f)){
                int val = map.get(f);
                val++;
                map.put(f,val);
            }
            else{
                map.put(f,1);
            }
        }
        double res = 0;
        for (Map.Entry<Fraction,Integer> e: map.entrySet()
             ) {
            Fraction f = e.getKey();
            int val = e.getValue();
            int needN = f.denominator - f.numerator;
            Fraction need = new Fraction(needN,f.denominator);
            System.out.println(val);
            if(f.doubleValue()== 0.5){
                if(val >= 2){
                    for(int i = val - 1; i >0; i--){
                        res = (res + i ) % 1000000007;
                    }
                }
                continue;
            }
            if(map.containsKey(need)){
                int x = map.get(need);
                double add = val * x / 2;
                res = (res + add) % 1000000007;
            }
        }
        return (int)res;
    }
    class Fraction extends Number {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("denominator is zero");
            }
            if (denominator < 0) {
                numerator *= -1;
                denominator *= -1;
            }
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction(int numerator) {
            this.numerator = numerator;
            this.denominator = 1;
        }

        public int getNumerator() {
            return this.numerator;
        }

        public int getDenominator() {
            return this.denominator;
        }

        public byte byteValue() {
            return (byte) this.doubleValue();
        }

        public double doubleValue() {
            return ((double) numerator) / ((double) denominator);
        }

        public float floatValue() {
            return (float) this.doubleValue();
        }

        public int intValue() {
            return (int) this.doubleValue();
        }

        public long longValue() {
            return (long) this.doubleValue();
        }

        public short shortValue() {
            return (short) this.doubleValue();
        }


        public boolean equals1(Fraction frac) {
            return this.compareTo(frac) == 0;
        }
        @Override
        public boolean equals(Object obj){
            Fraction f1 = null;
            if(obj instanceof Fraction)
                f1 = (Fraction)obj;
            if(f1.denominator == this.denominator && f1.numerator == this.numerator)
                return true;
            return false;
        }

        public int compareTo(Fraction frac) {
            long t = this.getNumerator() * frac.getDenominator();
            long f = frac.getNumerator() * this.getDenominator();
            int result = 0;
            if (t > f) {
                result = 1;
            } else if (f > t) {
                result = -1;
            }
            return result;
        }

        @Override
        public int hashCode(){
            StringBuffer sb = new StringBuffer();
            sb.append(numerator).append('.').append(denominator);

            return sb.toString().hashCode();
        }
    }
}
