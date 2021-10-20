package Easy;

public class Q345 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0, j = s.length()-1; i < j; ){
            while( i < s.length() && arr[i] != 'a' && arr[i] != 'e' && arr[i] != 'i' && arr[i] != 'o' && arr[i] !='u' && arr[i] != 'A' && arr[i] != 'E' && arr[i] != 'I' && arr[i] != 'O' && arr[i] !='U'){
                i++;
                if( i >= j)
                    return new String(arr);
            }
            while( j >= 0 && arr[j] != 'a' && arr[j] != 'e' && arr[j] != 'i' && arr[j] != 'o' && arr[j] !='u' && arr[j] != 'A' && arr[j] != 'E' && arr[j] != 'I' && arr[j] != 'O' && arr[j] !='U'){
                j--;
                if( i >= j)
                    return new String(arr);
            }
            if( i < s.length() && j >= 0){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Q345 q = new Q345();
        System.out.println(q.reverseVowels("hello"));
    }
}
