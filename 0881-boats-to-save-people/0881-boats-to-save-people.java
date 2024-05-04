class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);
        int i=0,j=people.length-1;
        while(i<=j){
            if((people[i]+people[j])<=limit){
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
}