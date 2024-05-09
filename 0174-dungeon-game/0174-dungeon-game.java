class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int dp[][]=new int[dungeon.length][dungeon[0].length];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return MinimumHP(dungeon,0,0,dp);
    }
    public static int MinimumHP(int arr[][],int cr,int cc,int dp[][]){
        if(cr==arr.length || cc>=arr[0].length){
            return Integer.MAX_VALUE;
        }
        if(cr==arr.length-1 && cc==arr[0].length-1){
            return arr[cr][cc] > 0 ? 1 : 1 - arr[cr][cc];
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        int left = MinimumHP(arr,cr,cc+1,dp);
        int right = MinimumHP(arr,cr+1,cc,dp);

        int hp=Math.min(left,right)-arr[cr][cc];

        return dp[cr][cc] = hp > 0 ? hp : 1;
    }
}