class Solution {
    public int search(int[] nums, int target) {
        if (nums.length==1) {
            if (target==nums[0]) return 0;
            else return -1;
        }
        int lo=0,hi=nums.length-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if (nums[mid]==target) return mid;
            if (nums[hi]==target) return hi;
            if(nums[mid]>nums[hi]) lo=mid+1;
            else hi=mid;
        }
        if (lo>0) {
            if (target>= nums[0] && target<=nums[lo-1]) {
                return find(nums,target,0,lo-1);
            }
            if (target<=nums[nums.length-1] && target>=nums[lo]) return find(nums,target,lo,nums.length-1);
        } else return find(nums,target,0,nums.length-1);
         
        return -1;
    }
    public int find(int[] nums,int target,int start,int end) {
        if (start<=end) {
            if (nums[start]==target) return start;
            if (nums[end]==target) return end;
            if (nums[(start+end)/2]==target) return (start+end)/2;
            else if (nums[(start+end)/2]>target) return find(nums,target,start,(start+end)/2-1);
            else {
                return find(nums,target,(start+end)/2+1,end);
            }
        } else return -1;
    } 
}
