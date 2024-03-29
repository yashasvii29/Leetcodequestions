class Solution {
    public String reverseWords(String s) {
        // String arr[] = s.split(" +");
        // StringBuilder sb = new StringBuilder();

        // for(int i=arr.length-1; i>= 0; i--){
        //     sb.append(arr[i] + " ");
        // }
        // return sb.toString().trim();



        	s = s.trim();
		String[] arr = s.split("\s+");
		String ans = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			ans = ans + arr[i] + " ";
		}
		return ans.trim();
    }
}