class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int carry = (nums1.length + nums2.length + 1) % 2;
        int r = 0, r1 = 0,r2 = 0;
        int x = 0,y = 0;
        int i = 0;
        boolean end = false;
        int target = ((nums1.length + nums2.length)/2) + 1;
        while(i < target) {
            if (x < nums1.length && y < nums2.length) {
                if (nums1[x] <= nums2[y]) {
                    r = nums1[x];
                    x++;
                } else {
                    r = nums2[y];
                    y++;
                }
            } else if (x == nums1.length) {
                    r = nums2[y];
                    y++;
            } else if (y == nums2.length) {
                    r = nums1[x];
                    x++;
            }

            if (target - i == 1) {
                r1 = r;
            } else if (target - i == 2) {
                r2 = r;
            }
            i++;
        }
        if (carry == 0) {
            return r1;
        } else {
            return (r1 + r2) / 2.0;
        }
    }
}