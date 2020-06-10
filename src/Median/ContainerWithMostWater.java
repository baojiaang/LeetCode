package Median;
/*
* Solution: This is a two pointer problem, assume we have two pointer, left and right,
* Firstly, we assign left pointer to 0, right pointer to the array's right bound, then
* each time we move the pointer with minimum height[pointer], for example, height[left] is 5, height[right] is 10, we move the left pointer to the right
*
* */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int leftIndex=0;
        int rightIndex=height.length-1;
        int leftWall=height[leftIndex];
        int rightWall=height[rightIndex];
        int wall=Math.max(leftWall,rightWall);
        int max=getArea(leftIndex,rightIndex,leftWall,rightWall);
        while(leftIndex!=rightIndex){
           // System.out.println(leftWall+" "+rightWall);
            if(leftWall<=rightWall) {
                leftIndex++;
                leftWall=height[leftIndex];
                int area=getArea(leftIndex,rightIndex,height[leftIndex],rightWall);
                if(area>max){
                    max=area;
                }
            }
            else{
                rightIndex--;
                rightWall=height[rightIndex];
                int area=getArea(leftIndex,rightIndex,leftWall,height[rightIndex]);
                if(area>max){
                    max=area;
                }
            }
        }
        System.out.println(leftIndex+" "+rightIndex+" "+leftWall+" "+rightWall);
        return max;
    }
    public int getArea(int leftIndex,int rightIndex,int leftWall,int rightWall){
        int wall=Math.min(leftWall,rightWall);
        return wall*(rightIndex-leftIndex);
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater=new ContainerWithMostWater();
        int height[]={2,3,4,5,18,17,6};
        System.out.println(containerWithMostWater.maxArea(height));
    }
}
