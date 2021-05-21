package Median;
/*
* 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明: 

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/gas-station
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 有点有趣的数学问题   如果 0-k可行， k到k+1不可行，说明前面的努力没用，直接从k+1开始
*
*
* */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, xuhang = 0, start = 0;
        for(int i = 0; i < gas.length; i++){
            rest += gas[i] - cost[i];
            xuhang += gas[i] - cost[i];
            if(xuhang < 0){
                start = i+1;
                xuhang = 0;
            }
        }
        if(rest < 0)
            return -1;
        else
            return start;
    }
}
