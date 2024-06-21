class Solution {
    public int[] shuffle(int[] arr, int n) {
        // ArrayList<Integer> ll=new ArrayList<>();
		int ans[]=new int[arr.length];
		int mid=arr.length/2;
        int k=0;
		for(int i=0;i<mid;i++){
			// ll.add(arr[i]);
            ans[k++]=arr[i];
			if(mid+i<arr.length){
				// ll.add(arr[mid+i]);
                ans[k++]=arr[mid+i];
			}
		}

		if(arr.length%2!=0){
			// ll.add(arr[arr.length/2]);
            ans[k]=arr[arr.length/2];
		}
		return ans;
    }
}