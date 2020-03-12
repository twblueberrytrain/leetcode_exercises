class Solution {
public:
    void reverseWords(string &s) {
        int size = s.size();
        if (size == 0) {
            return;
        }
        int l = 0;
        int r = size - 1;
        char tmp;
        int start = 0;
        int i,j;
        bool allb = true;
        for (i = 0; i < size;i++) {
            if (s[i] == ' ') {
                for (j = 0;j < (i - start + 1) / 2;j++) {
                    swap(s[start + j], s[i - j - 1]);
                }
                start = i + 1;
            } else {
                allb = false;
            }
        }
        if (allb) {
            s = "";
            return ;
        }
        for (j = 0;j < (r - start + 1) / 2;j++) {
            swap(s[start + j], s[r - j]);
        }
        while(l < r) {
           swap(s[l],s[r]);
           l++;
           r--;
        }

        i = 0;
        while (true) {
            if (i + 1 < s.size()) {
                if (s[i] == ' '&& s[i + 1] == ' ') {
                    s.erase(s.begin()+ i);
                } else {
                    i++;
                }
            } else {
                break;
            }
        }

        while (s[0] == ' ') {
            s.erase(s.begin()+0);
        }
        while (true) {
            if (s[s.size() - 1]!= ' ') {
                break;
            }
            s.erase(s.begin() + s.size() - 1);
        }
    }
};