class Solution {
    public int nextGreaterElement(int n) {
        if (n < 10 || n >= 2147483647) {
            return -1;
        }
        if (n < 100) {
            if (n % 11 == 0) return -1;
            int a = n % 10;
            int b = n / 10;
            if (a < b) {
                return -1;
            }
            return a * 10 + b;
        }

        String ntmp = "" + n;
        char number[] = ntmp.toCharArray();
        int index = -1;
        for (int i = number.length - 1; i > 0 ;i--) {
            if ((int)number[i] > (int)number[i - 1]) {
                index = i;
                break;
            }
        }

        if (index < 0) {
            return -1;
        }

        int secondMin = 100;
        for (int i = index; i < number.length;i++) {
            if ((int)number[i] > (int)number[index - 1] && secondMin >= (int)number[i]) {
                secondMin = (int)number[i];
            }
        }

        for (int i = index; i < number.length;i++) {
            int min = 100;
            int x = i;
            for (int j = i;j < number.length; j++) {
                if (min > (int)number[j]) {
                    x = j;
                    min = (int)number[j];
                }
            }
            if (x != i) {
                char tmp = number[i];
                number[i] = number[x];
                number[x] = tmp;
            }
        }

        for (int i = index;i < number.length;i++) {
            if (number[i] == secondMin) {
                char tmp = number[i];
                number[i] = number[index - 1];
                number[index - 1] = tmp;
                break;
            }
        }

        try {
            String ret = String.valueOf(number);
            return Integer.parseInt(ret);
        } catch(Exception e) {
        }

        return -1;
    }
}