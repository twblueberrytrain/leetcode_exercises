#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

    /*
    Find any two samll side and one longest side, these three sides must be able to
    be a triagle if the sum of two samll side is bigger than longest side.
    */
    // version 1
    int triangleNumber(vector<int>& nums) {
        int sizeTable[1001], ans = 0, i ,j, k;
        bool type2[1001];

        memset(sizeTable, 0, sizeof sizeTable);
        memset(type2, 0, sizeof type2);

        for (i = 0; i < nums.size();i++) {
            sizeTable[nums[i]]++;
            if (sizeTable[nums[i]] > 1) {
                type2[nums[i]] = true;
            }

                //cout << nums[i] << ":" << type2[nums[i]] << endl;
        }
        for (i = 1; i < 1001;i++) {
            if (sizeTable[i] == 0) {
                continue;
            }
            if (sizeTable[i] >= 3) { // AAA
                ans += (sizeTable[i] * (sizeTable[i] - 1) * (sizeTable[i] - 2) / 3) >> 1;
            }
            for (j = i + 1;j < 1001;j++) {
                if (sizeTable[j] == 0) continue;
               // cout << i << ":" << type2[i] << ", " << j << ":" << type2[j] << endl;
                if (type2[i] && (i << 1) > j) { // AAB
                    //cout << "AAB:" << ((sizeTable[i] * (sizeTable[i] - 1) * sizeTable[j]) >> 1) << endl;
                    ans += (sizeTable[i] * (sizeTable[i] - 1) * sizeTable[j]) >> 1;
                }
                if (type2[j] ) { // ABB
                //cout << "ABB:" << ((sizeTable[j] * (sizeTable[j] - 1) * sizeTable[i]) >> 1) << endl;
                    ans += (sizeTable[j] * (sizeTable[j] - 1) * sizeTable[i]) >> 1;
                }
                // ABC
                for (k = j + 1; k < 1001;k++) {
                    if (sizeTable[k] > 0) {
                        ans += sizeTable[i] * sizeTable[j] * sizeTable[k];
                    }
                }
            }
        }
        return ans;
    };

int main(void) {
    vector<int> test = {2,2,3,4};
    cout << triangleNumber(test);
}