class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length<nums2.length){
            return Median(nums1,nums2);
        }
        else{
            return Median(nums2,nums1);
        }

    }
    public static double Median(int nums1[],int nums2[]){
            int lo = 0;
        int hi = nums1.length;
        int m = nums1.length;
        int n = nums2.length;
        while(lo<=hi){
            int c1 = (lo+hi)/2;
            int c2 = (m+n+1)/2-c1;
            int l1 = c1==0 ? Integer.MIN_VALUE : nums1[c1-1];
            int l2 = c2==0 ? Integer.MIN_VALUE : nums2[c2-1];
            int r1 = c1==m ? Integer.MAX_VALUE : nums1[c1];
            int r2 = c2==n ? Integer.MAX_VALUE : nums2[c2];
            if(l1<=r2 && l2<=r1){
                if((m+n)%2 == 0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2){
                hi = c1-1;
            }
            else{
                lo = c1+1;
            }
            }
            return 0.0;
    }
    
    }

        // int n=nums1.length;
        // int m=nums2.length;
        // int ans[]=new int[n+m];
        // int i=0,j=0,k=0;
        // while(i<n && j<m){
        //     if(nums1[i]<=nums2[j]){
        //         ans[k]=nums1[i];
        //         i++;
        //         k++;
        //     }
        //     else{
        //         ans[k]=nums2[j];
        //         j++;
        //         k++;
        //     }
        // }
        // while(i<n){
        //     ans[k]=nums1[i];
        //     i++;
        //     k++;
        // }
        // while(j<m){
        //     ans[k]=nums2[j];
        //     j++;
        //     k++;
        // }
        // double median=0.0;
        // int mid = ans.length/2;
        // if(ans.length%2==0) {
        //     median=(float)(ans[mid-1] + ans[mid])/2;
        //     return median;
        // } 
        // return ans[mid];
 