class Solution {
    public int[] twoSum(int[] nums, int target) {
        int residual;
        int [] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            residual = target - nums[i];
            if (residual < min || residual > max) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - residual == 0) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;
    }
}