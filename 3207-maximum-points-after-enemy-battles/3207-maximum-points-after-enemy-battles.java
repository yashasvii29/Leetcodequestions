class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        long c=0;
        int n=enemyEnergies.length;
        if(currentEnergy<enemyEnergies[0])
            return 0;
        long sum=currentEnergy;
        for(int i=1;i<n;i++){
            sum+=enemyEnergies[i];
        }
        return sum/enemyEnergies[0];
    }
}
