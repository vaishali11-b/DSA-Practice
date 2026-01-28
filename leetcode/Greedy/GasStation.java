package Greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for(int i : gas){
            totalGas += i;
        }
        for(int i : cost){
            totalCost += i;
        }
        if(totalGas < totalCost){
            return -1;
        }
        int startIndex = 0 , currentFuel =0 ,totalFuel=0;
         //    “If total gas is less than total cost, no solution exists; otherwise, greedily reset the start whenever current fuel becomes negative.”
        for(int i=0 ; i <gas.length ; i++){
            int net = gas[i]-cost[i];
            currentFuel = net;
            totalFuel += net;
            if(currentFuel <0){
                startIndex = i+1;
                currentFuel =0;
            }
        }
        if(totalFuel < 0){
            return -1;
        }
        return startIndex;
    }
}
