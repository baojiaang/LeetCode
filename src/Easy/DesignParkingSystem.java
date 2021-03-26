package Easy;

public class DesignParkingSystem {

}
class ParkingSystem {

    private int big;
    private int medium;
    private int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType){
            case 1:
                if(big > 0){
                    big--;
                    return true;
                }
                else{
                    return false;
                }
            case 2:
                if(medium > 0){
                    medium--;
                    return true;
                }
                else{
                    return false;
                }
            case 3:
                if(small > 0){
                    small--;
                    return true;
                }
                else{
                    return false;
                }
        }
            return false;
    }
}
