package Easy;

public class Q1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char maxChar = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for(int i = 1; i < releaseTimes.length; i++){
            int curTime = releaseTimes[i] - releaseTimes[i - 1];
            char curChar = keysPressed.charAt(i);
            if(curTime > maxTime || (curTime == maxTime && curChar > maxChar)){
                maxChar = curChar;
                maxTime = curTime;
            }
        }
        return maxChar;
    }
}
