class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        
        int n=energyDrinkA.length;
       
        
        long maxA = 0, maxB=0;
        for(int i=0; i<n; i++){
            long newMaxA = Math.max(maxA+energyDrinkA[i], maxB);
            long newMaxB = Math.max(maxB+energyDrinkB[i], maxA);
            maxA = newMaxA;
            maxB = newMaxB;
        }
        return Math.max(maxA, maxB);
    }
}