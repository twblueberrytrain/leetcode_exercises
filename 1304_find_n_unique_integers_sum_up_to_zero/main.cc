// O(n)
class Solution {
public:
    vector<int> sumZero(int n) {
        vector<int> ans;
        int i = 0;
        if (n % 2 == 1) {
            ans.push_back(0);
            i++;
        }
        int j = 1;
        for (; i < n; i+=2) {
            ans.insert(ans.begin(), -j);
            ans.push_back(j);
            j++;
        }
        return ans;
    }
};


/* The better anser from others */
class Solution {
public:
    vector<int> sumZero(int n) {
        vector<int> ans(n, 0);
        bool isEven = n % 2 == 0;

		int value = isEven ? -(n / 2) : -((n - 1) / 2);
		for (int i = 0; i < n; ++i) {
			if (value == 0 && isEven) {
				++value;
				--i;
				continue;
			}

			ans[i] = value;
			++value;
		}
        return ans;
    }
};