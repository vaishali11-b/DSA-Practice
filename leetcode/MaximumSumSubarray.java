class MaximumSumSubarray {
    public int maxSubArray(int[] nums) {
        //using divide and conquer algo
        int l=0 , r = nums.length-1;
        if(l == r){
            return nums[l];
        }
        int mid = (l+r)/2;
        int leftMax = maxiSubArray(nums , l , mid);
        //System.out.println("LeftMax = "+ leftMax);
        int rightMax = maxiSubArray(nums , mid+1 , r);
        int crossMax = maxCrossSubArray(nums , l, mid , r);

        return Math.max(leftMax, Math.max(rightMax, crossMax));
    }

    public int maxiSubArray(int[] nums ,int l , int right){
        int maxSoFar = Integer.MIN_VALUE , currMax = 0;
        for(int i=l ; i <=right ; i++){
            if(currMax < 0){
                currMax = 0;
            }
            currMax += nums[i];
            //System.out.println("currMax = "+ currMax);
            maxSoFar = Math.max(maxSoFar , currMax);
        }
        return maxSoFar;
    }

    public int maxCrossSubArray(int[] nums ,int l,int mid ,int r){
        int maxSoFarL = Integer.MIN_VALUE , currMaxL = 0;
         int maxSoFarR = Integer.MIN_VALUE , currMaxR = 0;
        for(int i=mid ;i>=0 ;i--){
            currMaxL += nums[i];
            maxSoFarL = Math.max(maxSoFarL , currMaxL);

        }
        for(int i=mid+1 ; i <=r ; i++){
            currMaxR += nums[i];
            maxSoFarR = Math.max(maxSoFarR , currMaxR);

        }
        //System.out.println("MaxCrossSum = "+ maxSoFarL+"+"+maxSoFarR);
        return maxSoFarL+maxSoFarR;
    }
}