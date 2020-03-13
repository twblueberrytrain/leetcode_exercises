class Solution {
    /*
    Find the only number. O(n^2)
    */
public:
    inline void swap(int &a, int &b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
    int singleNumber(vector<int>& nums) {
        int left, right;
        bool found;
        int current = 0;
        int temp;
        while(nums.size() > 1) {
            left = current + 1;
            right = nums.size() - 1;
            found = false;
            while(left <= right) {
                if (nums[left] == nums[current]) {
                    swap(nums[current + 1], nums[left]);
                    current += 2;
                    found = true;
                    break;
                } else {
                    left++;
                }
                if (nums[right] == nums[current]) {
                    swap(nums[current + 1], nums[right]);
                    current += 2;
                    found = true;
                    break;
                } else {
                    right--;
                }
            }
            if (!found) {
                return nums[current];
            }
        }
        return nums[0];
    }
};


/*
Dirty best method from others
O(n)
*/
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.size();i++) {
            ans ^= nums[i];
        }
        return ans;
    }
};

