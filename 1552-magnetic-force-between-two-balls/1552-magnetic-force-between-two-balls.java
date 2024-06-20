class Solution {
    public int maxDistance(int[] position, int m) {
        // this que is same as aggressive cows 
        // advance binary search
        Arrays.sort(position);
     
        int low=1;
		int high = position[position.length - 1] - position[0];
		int ans=0;
		while(low<=high) {
			int mid=(low+high)/2;
			if(ispossible(position,m,mid)) {
				ans=mid;
				low=mid+1;
				
			}
			else {
				high=mid-1;
			}
			
		}
		return ans;
		
	}
	public static boolean ispossible(int[] position,int m,int mid) {
        int pos=position[0];  // 1st position
		int count=1;  // 1 ball ko basket m daal diya
		for(int i=1;i<position.length;i++) {	
			// loop 1 se isliye chalaya hai kyuki 1 ball ko basket m rakh chuke hai
			if(position[i]-pos>=mid) {
				count++;
				pos=position[i];
			}
			if(count==m) 
				return true;
		}
		
		return false;

    }
}