package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryWatch {
    List<String> res = new ArrayList<>();
    public List<String> readBinaryWatch(int turnedOn) {
        int hour = 0;
        int minutes = 0;
        back_track(turnedOn,0,0,0,0);
        Collections.sort(res);
        return res;
    }

    public void back_track(int turnedOn, int hour, int minutes,int h, int m){
        if(turnedOn == 0){
            StringBuilder sb = new StringBuilder();
            if(h <= 11){
                sb.append(h+":");
            }
            else{
                return;
            }
            if(m < 60){
                if(m < 10){
                    sb.append("0" + m);
                }
                else{
                    sb.append(m);
                }
            }
            else{
                return;
            }
            res.add(sb.toString());
            return;
        }
        while(minutes <= 5 && turnedOn > 0){
            m += Math.pow(2,minutes);
            turnedOn--;
            minutes++;
            back_track(turnedOn,hour,minutes,h,m);
           // minutes--;
            turnedOn++;
            m -= Math.pow(2,minutes-1);
        }
        while(hour <= 3 && turnedOn > 0){
            h += Math.pow(2,hour);
            turnedOn--;
            hour++;
            back_track(turnedOn,hour,minutes,h,m);
          //  hour--;
            turnedOn++;
            h -= Math.pow(2,hour-1);
        }
        
    }

    public static void main(String[] args) {
        BinaryWatch binaryWatch = new BinaryWatch();
        System.out.println(binaryWatch.readBinaryWatch(3));
    }
}
