class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = 0;

//   If nums1.length is odd (\U0001d45a%2≠0m%2=0), it means every element of nums2 is XORed an odd number of times in the full pairing.
// Therefore, XOR all elements of nums2 into ans.
        if (m % 2 != 0) {
            // if nums1 has odd length then the elements of nums2 will stay
            for (int num : nums2) {
            ans ^= num;
        }
        }


//         If nums2.length is odd (\U0001d45b%2≠0n%2=0), it means every element of nums1 is XORed an odd number of times in the full pairing.
// Therefore, XOR all elements of nums1 into ans.
//         }
        if (n % 2 != 0) {
             // if nums2 has odd length then the elements of nums1 will stay
          for (int num : nums1) {
            ans ^= num;
        }
        }

        return ans;
    }
}

// brute force approach gives tle
// time complexity O(m*n)

// class Solution {
//     public int xorAllNums(int[] nums1, int[] nums2) {
//         int n=nums1.length;
//         int m=nums2.length;
//         int k=0;
//         int nums3[]=new int[n*m];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 nums3[k++]=nums1[i]^nums2[j];
//             }
//         }

//         int ans=0;
//         for(int val:nums3){
//             ans^=val;
//         }
//         return ans;
//     }
// }