class Solution {
    public int trap(int[] height) {
        if (height.length < 3)  return 0;
        int startEnd = 0;
        int endEnd = 0;
        int maxValue = 0;
        int ret = 0;
        int value = height[0];
        for (int i = 0 ; i <height.length;i++) {
            if (maxValue < height[i]) {
                maxValue = height[i];
            }
        }

        for (int i = height.length - 1; i >=0; i--) {
            if (maxValue == height[i]) {
                startEnd = i;
                endEnd = i;
                break;
            }
        }

        for (int i = 1; i < startEnd;i++) {
            if (value < height[i]) {
                value = height[i];
            } else {
                ret += value - height[i];
            }
        }

        if (startEnd < height.length - 2) {
            value = height[height.length - 1];
            for(int i = height.length - 2; i >= endEnd; i--) {
                if (value < height[i]) {
                    value = height[i];
                } else {
                    ret += value - height[i];
                }
            }
        }

        return ret;
    }
}