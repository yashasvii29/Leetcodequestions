class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        if(arr.length==1){
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((arr[i] | arr[j]) == arr[j]) {
                break;
        }
            arr[j] |= arr[i];
            set.add(arr[j]);
            }
        }
        return set.size();
    }
}

// brute force approach 
//  it gives tle tc= O(n2)

// class Solution {
//     public int subarrayBitwiseORs(int[] arr) {
//         if(arr.length==1){
//             return 1;
//         }
//         Set<Integer> set=new HashSet<>();
//         int n=arr.length;
//         for(int i=0;i<n;i++){
//             int ans=0;
//             ans|=arr[i];
//              set.add(ans);
//             for(int j=i+1;j<n;j++){
//                 ans|=arr[j];
//                  set.add(ans);

//             }
           
//         }
//         return set.size();
//     }
// }