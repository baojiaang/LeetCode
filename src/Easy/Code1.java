package Easy;

public class Code1 {
    public int paintingPlan(int n, int k) {
        if (k==0)
            return 1;
        int result = 0;
        int a = k/n;
        if (k<n){
            return 0;
        }
        if(k==n*n){
            return 1;
        }
        if ((n*n)%k!=0){
            if(k==n*n-1)
                return 4;
            return 0;
        }
        else{
            System.out.println(comb(n,a));
           result= comb(n,a)*2;
        }
        return result;
    }
    public int comb(int m,int n){
        if(n==0)
            return 1;
        if (n==1)
            return m;
        if(n>m/2)
            return comb(m,m-n);
        if(n>1)
            return comb(m-1,n-1)+comb(m-1,n);

        return -1;
    }

    public static void main(String[] args) {
        Code1 c= new Code1();
        System.out.println(c.paintingPlan(4,8));
    }
}
