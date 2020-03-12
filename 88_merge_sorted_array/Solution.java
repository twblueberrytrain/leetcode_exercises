class Solution {
    public int mySqrt(int x) {
        switch (x) {
            case 0:
            case 1:
                return x;
            case 2:
            case 3:
                return 1;
            default:
                return theSQRT(x);
        }
    }

    private int theSQRT(int x) {
        int index = 0;
        int n = x;
        int ret = 0;
        int suber = 0;
        int rest = 0;
        List<Integer> rec = new ArrayList<>();
        while(n > 0) {
            rec.add(n % 100);
            n = n / 100;
            index++;
        }
        n = x;

        for (int i = 0; i < index;i++) {
            int round = rec.get(index - i - 1) + rest * 100;
            int turn = 0;
            for (int j = 1;j <= 10;j++) {
                int tmp = (suber * 10 + j) * j;
                if (round - tmp < 0) {
                    turn = j - 1;
                    break;
                }
            }

            int tmp = (suber * 10 + turn) * turn;
            ret = ret * 10 + turn;
            suber = suber * 10 + 2 * turn;
            rest = (round - tmp);
        }
        return ret;
    }
}