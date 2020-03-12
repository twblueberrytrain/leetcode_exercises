class Solution {
    public int majorityElement(int[] nums) {
        int[] size = new int [nums.length];
        int counter;
        int max = nums.length;
        int half = (max + 1)/ 2;
        for (int i = 0; i < max;i++) {
            for (int j = 0; j < half; j++) {
                if (nums[i] == nums[j]) {
                    size[j]++;
                    if (size[j] >= half) {
                        return nums[j];
                    }
                    break;
                }
            }
        }
        return nums[0];
    }
}