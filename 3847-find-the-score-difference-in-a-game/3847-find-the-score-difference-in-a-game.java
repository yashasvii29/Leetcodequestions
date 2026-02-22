class Solution {
    public int scoreDifference(int[] nums) {
        // two pointers approach
        boolean first_player_active = true;
        boolean second_player_active = false;

       int first_score = 0;
       int second_score = 0;
        int j=1;
        for (int i=0;i<nums.length;i++){
            if(nums[i]%2!=0 ){
               if(first_player_active){
                    second_player_active = true;
                    first_player_active = false;
                }
                else{
                  second_player_active = false;
                    first_player_active = true;  
                }
            }
            
             if (i!=0 && 6*j % i ==1){
                if(first_player_active){
                    second_player_active = true;
                    first_player_active = false;
                }
                else{
                  second_player_active = false;
                    first_player_active = true;  
                }
                j++;
            }
             if(first_player_active){
                first_score+=nums[i];
            }
            if(second_player_active){
                second_score+=nums[i];
            }
        }
        int total_diff = first_score- second_score;
        return total_diff;
        
    }
}