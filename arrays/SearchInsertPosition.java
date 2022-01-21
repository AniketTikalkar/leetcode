public class SearchInsertPosition {

    public boolean withinLimit(int x,int n){
        return x>=0 && x <=n;
    }
    public int searchInsert(int[] nums, int target) {
        int ans = -1;
        int h = nums.length -1;
        int l =0;
        while(h >= l){
            int m = l + (h -l)/2 ;
            if(nums[m] == target){
                ans = m;
                break;
            }
            else if(target > nums[m]){
                l = m +1;
            }
            else{
                h = m-1;
            }
        }
        //if target was not found , last element would be at index h
        if(ans == -1){
            if( withinLimit(h,nums.length -1) && target > nums[h]){
                ans = h +1;
            }
            else{
                ans = 0;
            }
            
        }
        return ans;
    }
        public static void main(String[] args) {
        /**
         * Given a sorted array of distinct integers and a target value, return the
         * index if the target is found. If not, return the index where it would be if
         * it were inserted in order.
         */
    }
}
